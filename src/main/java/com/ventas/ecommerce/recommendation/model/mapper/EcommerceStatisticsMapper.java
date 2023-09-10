package com.ventas.ecommerce.recommendation.model.mapper;

import com.ventas.ecommerce.recommendation.model.dto.EcommerceStatisticsDto;
import com.ventas.ecommerce.recommendation.model.entity.EcommerceStatistics;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EcommerceStatisticsMapper {
    EcommerceStatistics toEntity(EcommerceStatisticsDto ecommerceStatisticsDto);

    EcommerceStatisticsDto toDto(EcommerceStatistics ecommerceStatistics);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EcommerceStatistics partialUpdate(EcommerceStatisticsDto ecommerceStatisticsDto, @MappingTarget EcommerceStatistics ecommerceStatistics);
}