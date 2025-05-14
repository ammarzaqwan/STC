package com.assessment.STC.mapper.buyer;

import com.assessment.STC.dto.buyer.BuyerReqDTO;
import com.assessment.STC.dto.buyer.BuyerResDTO;
import com.assessment.STC.model.Buyer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuyerMapper {

    Buyer toEntity(BuyerReqDTO dto);
    BuyerResDTO toDto(Buyer buyer  );
}



