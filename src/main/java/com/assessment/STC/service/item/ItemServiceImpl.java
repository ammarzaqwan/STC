package com.assessment.STC.service.item;

import com.assessment.STC.dto.item.ItemReqDTO;
import com.assessment.STC.dto.item.ItemResDTO;
import com.assessment.STC.dto.seller.LightSellerDTO;
import com.assessment.STC.dto.seller.SellerResDTO;
import com.assessment.STC.exception.ApiException;
import com.assessment.STC.mapper.item.ItemMapper;
import com.assessment.STC.model.Item;
import com.assessment.STC.model.Seller;
import com.assessment.STC.repository.item.ItemRepository;
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
public class ItemServiceImpl implements ItemService{
    private final ItemRepository repository;
    private final ItemMapper mapper;

    private final SellerRepository sellerRepository;

    @Override
    public ItemResDTO addItems(ItemReqDTO dto) {

        Item item=mapper.toEntity(dto);

        try{
            Item saved = repository.save(item);
            return mapper.toDto(saved);
        } catch(DataIntegrityViolationException e){

            throw new ApiException("Item details already exists", HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    public List<ItemResDTO> getAllItems() {
        List<Item> Items = repository.findAll();
        if (Items.isEmpty()) {
            throw new ApiException("No item found", HttpStatus.NOT_FOUND);
        }
        return Items.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemResDTO updItems(ItemReqDTO dto, UUID id) {
        Item Items = repository.findById(id)
                .orElseThrow(() -> new ApiException("Item not exist", HttpStatus.BAD_REQUEST));

        Items.setDescription(dto.getDescription());
        Items.setName(dto.getName());
        Items.setQuantity(dto.getQuantity());
        Items.setPrice(dto.getQuantity());

        try {
            Item saved = repository.save(Items);
            return mapper.toDto(saved);
        } catch (DataIntegrityViolationException e) {
            throw new ApiException("Email or phone number already exists", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ItemResDTO getItemsById(UUID id) {
        Item Item = repository.findById(id)
                .orElseThrow(()-> new ApiException("Item not found",HttpStatus.BAD_REQUEST));

        return mapper.toDto(Item);
    }

    @Override
    public void deleteItems(UUID id) {
        Item Item = repository.findById(id)
                .orElseThrow(()-> new ApiException("Item not found",HttpStatus.BAD_REQUEST));

        repository.delete(Item);
    }

    public ItemResDTO addItemsSeller(ItemReqDTO dto,UUID id){
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        Item item = Item.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .seller(seller)
                .build();

        Item saved = repository.save(item);

        return ItemResDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .price(saved.getPrice())
                .quantity(saved.getQuantity())
                .seller(LightSellerDTO.builder()
                        .id(seller.getId())
                        .name(seller.getName())
                        .email(seller.getEmail())
                        .build())
                .build();
    }

    public  List<ItemResDTO> getItemsSeller(UUID id){
        List<Item> items = repository.findBySellerId(id);

        return items.stream().map(item -> ItemResDTO.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .description(item.getDescription())
                        .price(item.getPrice())
                        .quantity(item.getQuantity())
                        .seller(LightSellerDTO.builder()
                                .id(item.getSeller().getId())
                                .name(item.getSeller().getName())
                                .email(item.getSeller().getEmail())
                                .build())
                        .build())
                .toList();
    }
}
