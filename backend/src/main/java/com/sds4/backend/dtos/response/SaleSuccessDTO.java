package com.sds4.backend.dtos.response;

import com.sds4.backend.models.entities.Seller;
import lombok.Data;

import java.io.Serializable;

@Data
public class SaleSuccessDTO implements Serializable {
    private static final long serialVersionUID = 1L;    //? atributo do serializable

    //Atributos
    private String sellername;
    private Long visited;   //? quantidade de visitas
    private Long deals;     //? quantidade de negocios fechados

    //Construtor personalizado
    public SaleSuccessDTO(Seller seller, long visited, long deals) {
        this.sellername = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }
}
