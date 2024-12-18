package com.catalogmsa.util;

import com.catalogmsa.jpa.CatalogEntity;
import com.catalogmsa.jpa.CatalogRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class BeforeStart {

    private final CatalogRepository catalogRepository;

    @PostConstruct
    public void startInit(){
        log.warn("실행됨!!!!");
        catalogRepository.save(makeCatalog("CATALOG001","Berlin",100,1500));
        catalogRepository.save(makeCatalog("CATALOG002","Tokyo",110,1000));
        catalogRepository.save(makeCatalog("CATALOG003","Paris",120,2000));
    }

    private CatalogEntity makeCatalog(String productId, String productName, Integer stock, Integer unitPrice){
        return CatalogEntity.builder()
                .productId(productId)
                .productName(productName)
                .stock(stock)
                .unitPrice(unitPrice)
                .build();
    }
}
