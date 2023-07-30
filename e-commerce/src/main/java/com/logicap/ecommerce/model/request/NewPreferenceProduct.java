package com.logicap.ecommerce.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewPreferenceProduct {
    private String accessToken;
    private List<PreferenceItemProduct> items;
    private PayerInfo payerInfo;
}
