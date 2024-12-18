package com.catalogmsa.service;

import com.catalogmsa.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
