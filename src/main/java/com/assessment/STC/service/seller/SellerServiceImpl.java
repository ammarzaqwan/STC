package com.assessment.STC.service.seller;

import com.assessment.STC.dto.seller.SellerReqDTO;
import com.assessment.STC.dto.seller.SellerResDTO;
import com.assessment.STC.exception.ApiException;
import com.assessment.STC.mapper.seller.SellerMapper;
import com.assessment.STC.model.Seller;
import com.assessment.STC.repository.seller.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {
    private final SellerRepository repository;
    private final SellerMapper mapper;


    @Override
    public SellerResDTO addSellers(SellerReqDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()){
            throw new ApiException("Email for this user", HttpStatus.BAD_REQUEST);

        }
        Seller seller=mapper.toEntity(dto);

        try{
            Seller saved = repository.save(seller);
            return mapper.toDto(saved);
        } catch(DataIntegrityViolationException e){

            throw new ApiException("Seller details already exists", HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    public List<SellerResDTO> getAllSellers() {
        List<Seller> Sellers = repository.findAll();
        if (Sellers.isEmpty()) {
            throw new ApiException("No book found", HttpStatus.NOT_FOUND);
        }
        return Sellers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SellerResDTO updSellers(SellerReqDTO dto, UUID id) {
        Seller Sellers = repository.findById(id)
                .orElseThrow(() -> new ApiException("Seller not exist", HttpStatus.BAD_REQUEST));

        Sellers.setEmail(dto.getEmail());
        Sellers.setName(dto.getName());

        try {
            Seller saved = repository.save(Sellers);
            return mapper.toDto(saved);
        } catch (DataIntegrityViolationException e) {
            throw new ApiException("Email or phone number already exists", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SellerResDTO getSellersById(UUID id) {
        Seller Seller = repository.findById(id)
                .orElseThrow(()-> new ApiException("Seller not found",HttpStatus.BAD_REQUEST));

        return mapper.toDto(Seller);
    }

    @Override
    public void deleteSellers(UUID id) {
        Seller Seller = repository.findById(id)
                .orElseThrow(()-> new ApiException("Seller not found",HttpStatus.BAD_REQUEST));

        repository.delete(Seller);
    }
}
