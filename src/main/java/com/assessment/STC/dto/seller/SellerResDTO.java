package com.assessment.STC.dto.seller;

import com.assessment.STC.dto.item.ItemResDTO;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerResDTO {
    private UUID id;
    private String name;
    private String email;
    private List<ItemResDTO> items;
}
