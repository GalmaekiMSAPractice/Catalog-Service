package com.catalogmsa.util;

import com.catalogmsa.jpa.CatalogEntity;
import com.catalogmsa.vo.ResponseCatalog;

public class CatalogConverter {
    public static ResponseCatalog catalogToResponse(CatalogEntity entity){
        ResponseCatalog result = new ResponseCatalog();
        result.setProductId(entity.getProductId());
        result.setProductName(entity.getProductName());
        result.setUnitPrice(entity.getUnitPrice());
        result.setStock(entity.getStock());
//        result.setTotalPrice();
        result.setCreatedAt(entity.getCreatedAt());
        return result;
    }
}
