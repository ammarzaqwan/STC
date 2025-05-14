package com.assessment.STC.mapper.item;

import com.assessment.STC.dto.buyer.BuyerReqDTO;
import com.assessment.STC.dto.buyer.BuyerResDTO;
import com.assessment.STC.dto.item.ItemReqDTO;
import com.assessment.STC.dto.item.ItemResDTO;
import com.assessment.STC.model.Buyer;
import com.assessment.STC.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item toEntity(ItemReqDTO dto);
    ItemResDTO toDto(Item item  );
}