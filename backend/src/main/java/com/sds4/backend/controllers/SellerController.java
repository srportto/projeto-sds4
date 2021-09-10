package com.sds4.backend.controllers;

import com.sds4.backend.dtos.response.SellerDTO;
import com.sds4.backend.services.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
@AllArgsConstructor
public class SellerController {

    private final SellerService service;

//    @GetMapping
//    public ResponseEntity<Page<UsuarioDTO>> findAll(Pageable pageable){
//        Page<UsuarioDTO> pageClient = service.findAllPaged(pageable);
//        return ResponseEntity.ok().body(pageClient);
//    }

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll(){
        List<SellerDTO> sellerList = service.findAll();
        return ResponseEntity.ok().body(sellerList);
    }

}
