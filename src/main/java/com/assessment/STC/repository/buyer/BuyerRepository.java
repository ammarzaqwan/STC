package com.assessment.STC.repository.buyer;

import com.assessment.STC.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface BuyerRepository  extends JpaRepository<Buyer, UUID> {
    Optional<Object> findByEmail( String email);

}
