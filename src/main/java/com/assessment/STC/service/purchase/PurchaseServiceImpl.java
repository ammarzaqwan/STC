package com.assessment.STC.service.purchase;

import com.assessment.STC.dto.item.ItemResDTO;

import com.assessment.STC.dto.buyer.BuyerResDTO;
import com.assessment.STC.dto.marketplace.PurchaseReqDTO;
import com.assessment.STC.dto.marketplace.PurchaseResDTO;
import com.assessment.STC.model.Buyer;
import com.assessment.STC.model.Item;
import com.assessment.STC.model.Purchase;
import com.assessment.STC.repository.buyer.BuyerRepository;
import com.assessment.STC.repository.item.ItemRepository;
import com.assessment.STC.repository.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements  PurchaseService{

    private final PurchaseRepository purchaseRepository;
    private final BuyerRepository buyerRepository;
    private final ItemRepository itemRepository;


    @Override
    public PurchaseResDTO createPurchase(PurchaseReqDTO reqDTO) {
        Buyer buyer = buyerRepository.findById(reqDTO.getBuyerId())
                .orElseThrow(() -> new RuntimeException("Buyer not found"));

        Item item = itemRepository.findById(reqDTO.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        if (item.getQuantity() < reqDTO.getQuantity()) {
            throw new RuntimeException("Not enough stock available");
        }

        item.setQuantity(item.getQuantity() - reqDTO.getQuantity());

        Purchase purchase = Purchase.builder()
                .buyer(buyer)
                .item(item)
                .quantity(reqDTO.getQuantity())
                .purchaseDate(new Timestamp(System.currentTimeMillis()))
                .build();

        Purchase savedPurchase = purchaseRepository.save(purchase);

        return PurchaseResDTO.builder()
                .id(savedPurchase.getId())
                .buyer(BuyerResDTO.builder()
                        .id(buyer.getId())
                        .name(buyer.getName())
                        .email(buyer.getEmail())
                        .build())
                .item(ItemResDTO.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .description(item.getDescription())
                        .price(item.getPrice())
                        .quantity(item.getQuantity()) // updated quantity after purchase
                        .seller(null) // omit or populate based on your logic
                        .build())
                .quantity(savedPurchase.getQuantity())
                .purchaseDate(savedPurchase.getPurchaseDate())
                .build();
    }
}
