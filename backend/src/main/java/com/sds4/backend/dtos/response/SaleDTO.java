package com.sds4.backend.dtos.response;

import com.sds4.backend.models.entities.Sale;
import com.sds4.backend.models.entities.Seller;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class SaleDTO implements Serializable {
    private static final long serialVersionUID = 1L;    //? atributo do serializable

    //Atributos
    private Long id;
    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;
    private SellerDTO seller; // usando SellerDTO para não furar a arquitetura, pois a entidade do jpa nao deve ter interação nessa camada

    //Construtor personalizado
    public SaleDTO(Sale entity){
        this.id = entity.getId();
        this.visited = entity.getVisited();
        this.deals = entity.getDeals();
        this.amount = entity.getAmount();
        this.date = entity.getDate();
        this.seller = new SellerDTO(entity.getSeller());
    }
}
