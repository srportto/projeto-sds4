package com.sds4.backend.services;

import com.sds4.backend.dtos.response.SellerDTO;
import com.sds4.backend.models.entities.Seller;
import com.sds4.backend.repositories.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;

    public Page<SellerDTO> findAllPaged(Pageable pageable){
        Page<Seller> sellersList = sellerRepository.findAll(pageable);
        var result =  sellersList.map(seller -> new SellerDTO(seller));
        return result;
    }
}
