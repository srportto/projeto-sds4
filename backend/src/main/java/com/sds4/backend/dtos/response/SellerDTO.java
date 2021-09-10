package com.sds4.backend.dtos.response;

import com.sds4.backend.models.entities.Seller;
import lombok.Data;

import java.io.Serializable;

@Data
public class SellerDTO implements Serializable {
    private static final long serialVersionUID = 1L;    //? atributo do serializable

    //Atributos
    private Long id;
    private String name;

    //Construtor personalizado
    public SellerDTO(Seller entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
