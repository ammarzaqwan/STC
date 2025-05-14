package com.assessment.STC.dto.marketplace;


import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseReqDTO {
    private UUID buyerId;
    private UUID itemId;
    private Integer quantity;
}