package com.assessment.STC.service.seller;

import com.assessment.STC.dto.seller.SellerReqDTO;
import com.assessment.STC.dto.seller.SellerResDTO;

import java.util.List;
import java.util.UUID;

public interface SellerService {
    SellerResDTO addSellers(SellerReqDTO dto);
    List<SellerResDTO> getAllSellers();
    SellerResDTO updSellers(SellerReqDTO dto, UUID id);
    SellerResDTO getSellersById(UUID id);
    void deleteSellers(UUID id);
}
