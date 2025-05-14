package com.assessment.STC.repository.seller;

import com.assessment.STC.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface SellerRepository  extends JpaRepository<Seller, UUID> {
    Optional<Object> findByEmail( String email);

}
