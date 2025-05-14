package com.assessment.STC.repository.item;

import com.assessment.STC.model.Item;
import com.assessment.STC.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ItemRepository  extends JpaRepository<Item, UUID> {
    List<Item> findBySellerId(UUID sellerId);
}

