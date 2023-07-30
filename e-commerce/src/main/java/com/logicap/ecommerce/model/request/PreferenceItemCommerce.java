package com.logicap.ecommerce.model.request;

import com.logicap.ecommerce.model.entity.Commerce;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceItemCommerce implements Serializable {
    private String name;
    private Commerce event;
    private Integer quantity;
    private Float price;
}
