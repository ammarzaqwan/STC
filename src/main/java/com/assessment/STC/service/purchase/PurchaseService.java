package com.assessment.STC.service.purchase;


import com.assessment.STC.dto.buyer.BuyerReqDTO;
import com.assessment.STC.dto.buyer.BuyerResDTO;
import com.assessment.STC.dto.marketplace.PurchaseReqDTO;
import com.assessment.STC.dto.marketplace.PurchaseResDTO;

import java.util.List;
import java.util.UUID;

public interface PurchaseService {
    PurchaseResDTO createPurchase(PurchaseReqDTO reqDTO);
}
