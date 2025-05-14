package com.assessment.STC.dto.marketplace;
import com.assessment.STC.dto.buyer.BuyerResDTO;
import com.assessment.STC.dto.item.ItemResDTO;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseResDTO {
    private UUID id;
    private BuyerResDTO buyer;
    private ItemResDTO item;
    private Integer quantity;
    private Timestamp purchaseDate;
}
