package com.assessment.STC.service.item;

import com.assessment.STC.dto.item.ItemResDTO;
import com.assessment.STC.dto.item.ItemReqDTO;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    ItemResDTO addItems(ItemReqDTO dto);
    List<ItemResDTO> getAllItems();
    ItemResDTO updItems(ItemReqDTO dto, UUID id);
    ItemResDTO getItemsById(UUID id);
    void deleteItems(UUID id);

    ItemResDTO addItemsSeller(ItemReqDTO dto,UUID id);
    List<ItemResDTO> getItemsSeller(UUID id);
}
