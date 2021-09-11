package com.sds4.backend.services;

import com.sds4.backend.dtos.response.SaleDTO;
import com.sds4.backend.dtos.response.SellerDTO;
import com.sds4.backend.models.entities.Sale;
import com.sds4.backend.models.entities.Seller;
import com.sds4.backend.repositories.SaleRepository;
import com.sds4.backend.repositories.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAllPaged(Pageable pageable){
        Page<Sale> salePage = saleRepository.findAll(pageable);
        var result =  salePage.map(sale -> new SaleDTO(sale));
        return result;
    }

}
