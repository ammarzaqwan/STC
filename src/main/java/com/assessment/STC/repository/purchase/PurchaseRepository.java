package com.assessment.STC.repository.purchase;

import com.assessment.STC.model.Item;
import com.assessment.STC.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface PurchaseRepository  extends JpaRepository<Purchase, UUID> {

}

