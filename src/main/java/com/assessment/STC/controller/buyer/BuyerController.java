package com.assessment.STC.controller.buyer;

import com.assessment.STC.dto.buyer.BuyerReqDTO;
import com.assessment.STC.dto.buyer.BuyerResDTO;
import com.assessment.STC.service.buyer.BuyerService;
import com.assessment.STC.utils.ApiResponse;
import com.assessment.STC.utils.Record;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService service;

    @PostMapping("/api/buyers")
    public ResponseEntity<ApiResponse<BuyerResDTO>> addBuyer(@Valid @RequestBody BuyerReqDTO dto){
        BuyerResDTO Buyer =service.addBuyers(dto);

        ApiResponse<BuyerResDTO> response = new ApiResponse<>(
                Record.CREATE.getMessage(),
                Buyer,
                HttpStatus.CREATED.value()
        );
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //@GetMapping("/api/public/Buyers")
    @GetMapping("/api/buyers")
    public ResponseEntity<ApiResponse<List<BuyerResDTO>>> getAllBuyers(){
        List<BuyerResDTO> Buyers = service.getAllBuyers();

        ApiResponse<List<BuyerResDTO>> response = new ApiResponse<>(
                Record.RETRIEVE.getMessage(),
                Buyers,
                HttpStatus.OK.value()
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PatchMapping("/api/buyers/{uuid}")
    public ResponseEntity<ApiResponse<BuyerResDTO>> updBuyers(@PathVariable UUID uuid, @RequestBody BuyerReqDTO dto) {
        BuyerResDTO buyer = service.updBuyers(dto,uuid);

        ApiResponse<BuyerResDTO> response = new ApiResponse<>(
                Record.UPDATE.getMessage(),
                buyer,
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/api/buyers/{uuid}")
    public ResponseEntity<ApiResponse<BuyerResDTO>> getbuyersById(@PathVariable UUID uuid){
        BuyerResDTO buyer = service.getBuyersById(uuid);

        ApiResponse<BuyerResDTO> response = new ApiResponse<>(
                Record.RETRIEVE.getMessage(),
                buyer,
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/api/buyers/{uuid}")
    public ResponseEntity<ApiResponse<Void>> deleteBuyers(@PathVariable UUID uuid){
        service.deleteBuyers(uuid);

        ApiResponse<Void> response = new ApiResponse<>(
                Record.DELETE.getMessage(),
                null,
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
