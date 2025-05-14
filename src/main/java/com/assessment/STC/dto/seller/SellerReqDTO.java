package com.assessment.STC.dto.seller;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerReqDTO {
    private String name;
    private String email;
}
