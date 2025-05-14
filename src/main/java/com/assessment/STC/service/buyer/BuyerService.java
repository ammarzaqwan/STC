package com.assessment.STC.service.buyer;

import com.assessment.STC.dto.buyer.BuyerReqDTO;
import com.assessment.STC.dto.buyer.BuyerResDTO;

import java.util.List;
import java.util.UUID;

public interface BuyerService {
    BuyerResDTO addBuyers(BuyerReqDTO dto);
    List<BuyerResDTO> getAllBuyers();
    BuyerResDTO updBuyers(BuyerReqDTO dto, UUID id);
    BuyerResDTO getBuyersById(UUID id);
    void deleteBuyers(UUID id);
}
