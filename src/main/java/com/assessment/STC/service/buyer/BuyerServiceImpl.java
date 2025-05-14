package com.assessment.STC.service.buyer;

import com.assessment.STC.dto.buyer.BuyerReqDTO;
import com.assessment.STC.dto.buyer.BuyerResDTO;
import com.assessment.STC.exception.ApiException;
import com.assessment.STC.mapper.buyer.BuyerMapper;
import com.assessment.STC.model.Buyer;
import com.assessment.STC.repository.buyer.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository repository;
    private final BuyerMapper mapper;


    @Override
    public BuyerResDTO addBuyers(BuyerReqDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()){
            throw new ApiException("Email for this user", HttpStatus.BAD_REQUEST);

        }
        Buyer buyer=mapper.toEntity(dto);

        try{
            Buyer saved = repository.save(buyer);
            return mapper.toDto(saved);
        } catch(DataIntegrityViolationException e){

            throw new ApiException("Buyer details already exists", HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    public List<BuyerResDTO> getAllBuyers() {
        List<Buyer> buyers = repository.findAll();
        if (buyers.isEmpty()) {
            throw new ApiException("No book found", HttpStatus.NOT_FOUND);
        }
        return buyers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BuyerResDTO updBuyers(BuyerReqDTO dto, UUID id) {
        Buyer buyers = repository.findById(id)
                .orElseThrow(() -> new ApiException("Book not exist", HttpStatus.BAD_REQUEST));

        buyers.setEmail(dto.getEmail());
        buyers.setName(dto.getName());

        try {
            Buyer saved = repository.save(buyers);
            return mapper.toDto(saved);
        } catch (DataIntegrityViolationException e) {
            throw new ApiException("Email or phone number already exists", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public BuyerResDTO getBuyersById(UUID id) {
        Buyer buyer = repository.findById(id)
                .orElseThrow(()-> new ApiException("Book not found",HttpStatus.BAD_REQUEST));

        return mapper.toDto(buyer);
    }

    @Override
    public void deleteBuyers(UUID id) {
        Buyer buyer = repository.findById(id)
                .orElseThrow(()-> new ApiException("Book not found",HttpStatus.BAD_REQUEST));

        repository.delete(buyer);
    }
}
