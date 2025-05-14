package com.assessment.STC.controller.marketplace;

import com.assessment.STC.dto.marketplace.PurchaseReqDTO;
import com.assessment.STC.dto.marketplace.PurchaseResDTO;
import com.assessment.STC.service.item.ItemService;
import com.assessment.STC.service.purchase.PurchaseService;
import com.assessment.STC.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class purchase {
    private final PurchaseService service;

    @PostMapping("/api/purchases")
    public ResponseEntity<ApiResponse<PurchaseResDTO>> createPurchase(@RequestBody PurchaseReqDTO request) {
        PurchaseResDTO responseDTO = service.createPurchase(request);

        ApiResponse<PurchaseResDTO> response = new ApiResponse<>(
                "Purchase successful",
                responseDTO,
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
