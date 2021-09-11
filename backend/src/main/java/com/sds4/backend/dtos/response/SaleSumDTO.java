package com.sds4.backend.dtos.response;

import com.sds4.backend.models.entities.Seller;
import lombok.Data;

import java.io.Serializable;

@Data
public class SaleSumDTO implements Serializable {
    private static final long serialVersionUID = 1L;    //? atributo do serializable

    //Atributos
    private String sellername;
    private Double sum;

    //Construtor personalizado
    public SaleSumDTO(Seller seller, double sum){
        this.sellername = seller.getName();
        this.sum = sum;
    }
}
