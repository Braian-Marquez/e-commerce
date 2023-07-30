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
public class PayerInfo implements Serializable {
    private String name;
    private String surname;
    private String email;
    private PhoneInfo phone;
    private IdentificationInfo identification;
    private AddressInfo address;


    // Constructor, getters y setters
}
