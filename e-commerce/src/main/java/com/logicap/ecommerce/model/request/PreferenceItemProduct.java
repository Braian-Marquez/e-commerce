package com.logicap.ecommerce.model.request;

import com.logicap.ecommerce.model.entity.Commerce;
import com.logicap.ecommerce.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceItemProduct {
    private String name;
    private List<Product> event;
    private Integer quantity;
    private Float price;
}
