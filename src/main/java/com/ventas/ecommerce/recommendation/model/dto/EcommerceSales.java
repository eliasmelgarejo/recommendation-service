package com.ventas.ecommerce.recommendation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * The type Ecommerce sales.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EcommerceSales implements Serializable {
    private static final long serialVersionUID = 4212129403091423953L;
    private int mes;
    private int anio;
    private String productCode;
    private String productCategory;
    private int quantity;
}
