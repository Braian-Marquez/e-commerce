package com.logicap.ecommerce.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationInfo implements Serializable {
    private String type;
    private String number;

    // Constructor, getters y setters
}
