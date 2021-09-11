package com.sds4.backend.services;

import com.sds4.backend.dtos.responses.SaleDTO;
import com.sds4.backend.dtos.responses.SaleSuccessDTO;
import com.sds4.backend.dtos.responses.SaleSumDTO;
import com.sds4.backend.models.entities.Sale;
import com.sds4.backend.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public List<SaleSumDTO> listAmoutGroupedBySeller(){
       return saleRepository.amoutGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> listSuccessGroupedBySeller(){
        return saleRepository.successGroupedBySeller();
    }

}
