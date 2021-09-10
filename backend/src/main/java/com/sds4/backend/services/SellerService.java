package com.sds4.backend.services;

import com.sds4.backend.dtos.response.SellerDTO;
import com.sds4.backend.models.entities.Seller;
import com.sds4.backend.repositories.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;

    public List<SellerDTO> findAll(){
        List<Seller> sellersList = sellerRepository.findAll();
        var result =  sellersList.stream().map(seller -> new SellerDTO(seller)).collect(Collectors.toList());
        return result;
    }
}
