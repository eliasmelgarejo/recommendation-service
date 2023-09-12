package com.ventas.ecommerce.recommendation.service;

import com.ventas.ecommerce.recommendation.model.dto.EcommerceStatisticsDto;
import com.ventas.ecommerce.recommendation.model.entity.EcommerceStatistics;
import com.ventas.ecommerce.recommendation.model.mapper.EcommerceStatisticsMapper;
import com.ventas.ecommerce.recommendation.model.repository.EcommerceStatisticsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class EcommerceStatisticsService implements IEcommerceStatisticsService {
    private final EcommerceStatisticsRepository repository;
    private final EcommerceStatisticsMapper mapper;

    public EcommerceStatisticsService(EcommerceStatisticsRepository repository,
                                      EcommerceStatisticsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void addEcommerceStatistics(EcommerceStatisticsDto dto) throws Exception {
        log.debug("addEcommerceStatistics");
        //verificar si ya existe el producto en la base de datos
        if (repository.ExistsProduct(dto.getProductCode(), dto.getYear(), dto.getMonth())) {
            //si existe, recupero el registro e incremento la cantidad antes de actualizar la cantidad
            Optional<EcommerceStatistics> optionalEntity = repository.findFirstByProductCodeAndYearAndMonthOrderByIdDesc(dto.getProductCode(), dto.getYear(), dto.getMonth());
            if (optionalEntity.isPresent()) {
                EcommerceStatistics entity = optionalEntity.get();
                entity.setQuantity(entity.getQuantity() + dto.getQuantity());
                repository.saveAndFlush(entity);
            } else {
                log.error("Error al recuperar el registro de estadisticas");
                throw new Exception("Error al recuperar el registro de estadisticas");
            }
        } else {
            //si no existe, crearlo
            EcommerceStatistics entity = mapper.toEntity(dto);
            EcommerceStatistics result = repository.saveAndFlush(entity);
            if (result == null) {
                log.error("Error al guardar el registro de estadisticas");
                throw new Exception("Error al guardar el registro de estadisticas");
            }
        }
    }

    @Override
    public List<EcommerceStatisticsDto> recomendadosPorCategoria(String productCategory) {
        return repository.recomendadosPorCategoria(productCategory).stream().map(mapper::toDto).toList();
    }

    @Override
    public List<EcommerceStatisticsDto> recomendadosPorCategoriaMesAnio(String productCategory, int year, int month) {
        return repository.recomendadosPorCategoriaMesAnio(productCategory, year, month).stream().map(mapper::toDto).toList();
    }
}
