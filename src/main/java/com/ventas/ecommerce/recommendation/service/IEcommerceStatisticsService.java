package com.ventas.ecommerce.recommendation.service;

import com.ventas.ecommerce.recommendation.model.dto.EcommerceStatisticsDto;
import com.ventas.ecommerce.recommendation.model.entity.EcommerceStatistics;

import java.util.List;

public interface IEcommerceStatisticsService {
    void addEcommerceStatistics(EcommerceStatisticsDto dto) throws Exception;
    List<EcommerceStatisticsDto> recomendadosPorCategoria(String productCategory);
    List<EcommerceStatisticsDto> recomendadosPorCategoriaMesAnio(String productCategory, int year, int month);
}
