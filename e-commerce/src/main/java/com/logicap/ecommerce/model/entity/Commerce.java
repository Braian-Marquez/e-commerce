package com.logicap.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commerce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String info;
    private Boolean payService=false;
    @OneToOne
    private Location location;
    @OneToOne
    private Templates templates;
    @OneToMany
    private List<Phone> listPhone;
    @OneToMany
    private List<Product>productList;
    @OneToOne
    private OrderPayment orderPayment;
}
