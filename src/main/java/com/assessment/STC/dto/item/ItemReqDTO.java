package com.assessment.STC.dto.item;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemReqDTO {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private UUID sellerId;
}

