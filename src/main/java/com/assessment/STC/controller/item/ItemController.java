package com.assessment.STC.controller.item;




import com.assessment.STC.dto.item.ItemReqDTO;
import com.assessment.STC.dto.item.ItemResDTO;
import com.assessment.STC.service.item.ItemService;
import com.assessment.STC.utils.ApiResponse;
import com.assessment.STC.utils.Record;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @PostMapping("/api/items")
    public ResponseEntity<ApiResponse<ItemResDTO>> addItem(@Valid @RequestBody ItemReqDTO dto){
        ItemResDTO Item =service.addItems(dto);

        ApiResponse<ItemResDTO> response = new ApiResponse<>(
                Record.CREATE.getMessage(),
                Item,
                HttpStatus.CREATED.value()
        );
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //@GetMapping("/api/public/Items")
    @GetMapping("/api/items")
    public ResponseEntity<ApiResponse<List<ItemResDTO>>> getAllItems(){
        List<ItemResDTO> Items = service.getAllItems();

        ApiResponse<List<ItemResDTO>> response = new ApiResponse<>(
                Record.RETRIEVE.getMessage(),
                Items,
                HttpStatus.OK.value()
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PatchMapping("/api/items/{uuid}")
    public ResponseEntity<ApiResponse<ItemResDTO>> updItems(@PathVariable UUID uuid, @RequestBody ItemReqDTO dto) {
        ItemResDTO item = service.updItems(dto,uuid);

        ApiResponse<ItemResDTO> response = new ApiResponse<>(
                Record.UPDATE.getMessage(),
                item,
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/api/items/{uuid}")
    public ResponseEntity<ApiResponse<ItemResDTO>> getitemsById(@PathVariable UUID uuid){
        ItemResDTO item = service.getItemsById(uuid);

        ApiResponse<ItemResDTO> response = new ApiResponse<>(
                Record.RETRIEVE.getMessage(),
                item,
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/api/items/{uuid}")
    public ResponseEntity<ApiResponse<Void>> deleteItems(@PathVariable UUID uuid){
        service.deleteItems(uuid);

        ApiResponse<Void> response = new ApiResponse<>(
                Record.DELETE.getMessage(),
                null,
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/sellers/{uuid}/items")
    public ResponseEntity<ApiResponse<List<ItemResDTO>>> getSellerItems(@PathVariable UUID uuid){
        List<ItemResDTO> items = service.getItemsSeller(uuid);

        ApiResponse<List<ItemResDTO>> response = new ApiResponse<>(
                Record.RETRIEVE.getMessage(),
                items,
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/api/sellers/{uuid}/items")
    public ResponseEntity<ApiResponse<ItemResDTO>> addSellerItems(@Valid @RequestBody ItemReqDTO dto,@PathVariable UUID uuid){
        ItemResDTO item = service.addItemsSeller(dto,uuid);

        ApiResponse<ItemResDTO> response = new ApiResponse<>(
                Record.RETRIEVE.getMessage(),
                item,
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
