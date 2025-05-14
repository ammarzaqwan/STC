package com.assessment.STC.dto.buyer;

import com.assessment.STC.dto.marketplace.PurchaseResDTO;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class BuyerResDTO {
    private UUID id;
    private String name;
    private String email;
   private List<PurchaseResDTO> purchasedItems;
}