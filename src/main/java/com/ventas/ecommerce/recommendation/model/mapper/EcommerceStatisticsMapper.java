package com.ventas.ecommerce.recommendation.model.mapper;

import com.ventas.ecommerce.recommendation.model.dto.EcommerceStatisticsDto;
import com.ventas.ecommerce.recommendation.model.entity.EcommerceStatistics;
import org.mapstruct.*;

/**
 * The interface Ecommerce statistics mapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EcommerceStatisticsMapper {
    /**
     * To entity ecommerce statistics.
     *
     * @param ecommerceStatisticsDto the ecommerce statistics dto
     * @return the ecommerce statistics
     */
    EcommerceStatistics toEntity(EcommerceStatisticsDto ecommerceStatisticsDto);

    /**
     * To dto ecommerce statistics dto.
     *
     * @param ecommerceStatistics the ecommerce statistics
     * @return the ecommerce statistics dto
     */
    EcommerceStatisticsDto toDto(EcommerceStatistics ecommerceStatistics);

    /**
     * Partial update ecommerce statistics.
     *
     * @param ecommerceStatisticsDto the ecommerce statistics dto
     * @param ecommerceStatistics    the ecommerce statistics
     * @return the ecommerce statistics
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EcommerceStatistics partialUpdate(EcommerceStatisticsDto ecommerceStatisticsDto, @MappingTarget EcommerceStatistics ecommerceStatistics);
}