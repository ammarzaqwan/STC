package com.assessment.STC.dto.buyer;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class BuyerResDTO {
    private UUID id;
    private String name;
    private String email;
   // private List<PurchaseResponseDTO> purchasedItems;
}