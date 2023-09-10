package com.ventas.ecommerce.recommendation.service;

import com.ventas.ecommerce.recommendation.model.dto.EcommerceStatisticsDto;
import com.ventas.ecommerce.recommendation.model.entity.EcommerceStatistics;

import java.util.List;

public interface IEcommerceStatisticsService {
    void addEcommerceStatistics(EcommerceStatisticsDto dto) throws Exception;
    List<EcommerceStatistics> recomendadosPorCategoria(String productCategory);
    List<EcommerceStatistics> recomendadosPorCategoriaMesAnio(String productCategory, int year, int month);
}
