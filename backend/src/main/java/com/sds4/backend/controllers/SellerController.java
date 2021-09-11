package com.sds4.backend.controllers;

import com.sds4.backend.dtos.response.SellerDTO;
import com.sds4.backend.services.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sellers")
@AllArgsConstructor
public class SellerController {

    private final SellerService service;

    @GetMapping
    public ResponseEntity<Page<SellerDTO>> findAll(Pageable pageable){
        Page<SellerDTO> pageClient = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(pageClient);
    }

}
