package com.assessment.STC.dto.seller;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LightSellerDTO {
    private UUID id;
    private String name;
    private String email;
}
