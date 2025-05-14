package com.assessment.STC.mapper.seller;


import com.assessment.STC.dto.buyer.BuyerReqDTO;
import com.assessment.STC.dto.buyer.BuyerResDTO;
import com.assessment.STC.dto.seller.SellerReqDTO;
import com.assessment.STC.dto.seller.SellerResDTO;
import com.assessment.STC.model.Buyer;
import com.assessment.STC.model.Seller;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    Seller toEntity(SellerReqDTO dto);
    SellerResDTO toDto(Seller seller  );
}



