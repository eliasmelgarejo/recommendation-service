package com.ventas.ecommerce.recommendation.service;

import com.ventas.ecommerce.recommendation.model.dto.EcommerceStatisticsDto;
import com.ventas.ecommerce.recommendation.model.entity.EcommerceStatistics;

import java.util.List;

/**
 * The interface Ecommerce statistics service.
 */
public interface IEcommerceStatisticsService {
    /**
     * Add ecommerce statistics void.
     *
     * @param dto the dto
     * @return the void
     * @throws Exception the exception
     */
    void addEcommerceStatistics(EcommerceStatisticsDto dto) throws Exception;

    /**
     * Recomendados por categoria list.
     *
     * @param productCategory the product category
     * @return the list
     */
    List<EcommerceStatisticsDto> recomendadosPorCategoria(String productCategory);

    /**
     * Recomendados por categoria mes anio list.
     *
     * @param productCategory the product category
     * @param year            the year
     * @param month           the month
     * @return the list
     */
    List<EcommerceStatisticsDto> recomendadosPorCategoriaMesAnio(String productCategory, int year, int month);
}
