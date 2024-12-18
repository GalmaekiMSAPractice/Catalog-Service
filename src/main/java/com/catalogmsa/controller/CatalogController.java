package com.catalogmsa.controller;

import com.catalogmsa.jpa.CatalogEntity;
import com.catalogmsa.service.CatalogService;
import com.catalogmsa.vo.ResponseCatalog;
import com.catalogmsa.util.CatalogConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
@Slf4j
@RequiredArgsConstructor
public class CatalogController {
    private final  Environment env;
    private final  CatalogService catalogService;

    @GetMapping("/healthcheck")
    public String status() {
        return "Working Now";
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs(){
        Iterable<CatalogEntity> catalogList = catalogService.getAllCatalogs();

        List<ResponseCatalog> result= new ArrayList();
        catalogList.forEach(v->result.add(CatalogConverter.catalogToResponse(v)));
        return ResponseEntity.ok(result);
    }
}
