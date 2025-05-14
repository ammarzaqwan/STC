package com.assessment.STC.dto.item;
import com.assessment.STC.dto.seller.SellerResDTO;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResDTO {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private SellerResDTO seller;
}
