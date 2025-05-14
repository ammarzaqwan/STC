package com.assessment.STC.controller.seller;


import com.assessment.STC.dto.seller.SellerReqDTO;
import com.assessment.STC.dto.seller.SellerResDTO;
import com.assessment.STC.service.seller.SellerService;
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
public class SellerController {

    private final SellerService service;

    @PostMapping("/api/sellers")
    public ResponseEntity<ApiResponse<SellerResDTO>> addSeller(@Valid @RequestBody SellerReqDTO dto){
        SellerResDTO Seller =service.addSellers(dto);

        ApiResponse<SellerResDTO> response = new ApiResponse<>(
                Record.CREATE.getMessage(),
                Seller,
                HttpStatus.CREATED.value()
        );
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //@GetMapping("/api/public/Sellers")
    @GetMapping("/api/sellers")
    public ResponseEntity<ApiResponse<List<SellerResDTO>>> getAllSellers(){
        List<SellerResDTO> Sellers = service.getAllSellers();

        ApiResponse<List<SellerResDTO>> response = new ApiResponse<>(
                Record.RETRIEVE.getMessage(),
                Sellers,
                HttpStatus.OK.value()
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PatchMapping("/api/sellers/{uuid}")
    public ResponseEntity<ApiResponse<SellerResDTO>> updSellers(@PathVariable UUID uuid, @RequestBody SellerReqDTO dto) {
        SellerResDTO buyer = service.updSellers(dto,uuid);

        ApiResponse<SellerResDTO> response = new ApiResponse<>(
                Record.UPDATE.getMessage(),
                buyer,
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/api/sellers/{uuid}")
    public ResponseEntity<ApiResponse<SellerResDTO>> getbuyersById(@PathVariable UUID uuid){
        SellerResDTO buyer = service.getSellersById(uuid);

        ApiResponse<SellerResDTO> response = new ApiResponse<>(
                Record.RETRIEVE.getMessage(),
                buyer,
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/api/sellers/{uuid}")
    public ResponseEntity<ApiResponse<Void>> deleteSellers(@PathVariable UUID uuid){
        service.deleteSellers(uuid);

        ApiResponse<Void> response = new ApiResponse<>(
                Record.DELETE.getMessage(),
                null,
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
