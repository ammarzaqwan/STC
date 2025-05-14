package com.assessment.STC.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private double price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}

