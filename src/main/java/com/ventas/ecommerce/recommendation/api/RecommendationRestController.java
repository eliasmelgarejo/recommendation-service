package com.ventas.ecommerce.recommendation.api;


import com.nimbusds.jose.shaded.gson.Gson;
import com.ventas.ecommerce.recommendation.model.dto.EcommerceStatisticsDto;
import com.ventas.ecommerce.recommendation.service.IEcommerceStatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/v1/recommendation")
@Tag(name = "Recommendation", description = "API de Recomendaciones de Productos")
public class RecommendationRestController {

    private final IEcommerceStatisticsService service;
    private final Gson gson;

    public RecommendationRestController(IEcommerceStatisticsService service, Gson gson) {
        this.service = service;
        this.gson = gson;
    }

    @Operation(
            summary = "ByProductCategory",
            description = "List of recommended products by category",
            parameters = {
                    @Parameter(name = "productCategory", description = "productCategory", required = true, schema = @Schema(implementation = String.class))
            },
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "List of recommended products by category"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Error when recommending products by category")
            }
    )
    @GetMapping("/byProductCategory/{productCategory}")
    public ResponseEntity<List<EcommerceStatisticsDto>> byProductCategory(@PathVariable String productCategory) {
        try {
            log.info("Recommending products by category: {} ", productCategory);
            List<EcommerceStatisticsDto> productsRecommended = service.recomendadosPorCategoria(productCategory);

            log.info(" {} ", gson.toJson(productsRecommended));

            return new ResponseEntity<List<EcommerceStatisticsDto>>(productsRecommended, HttpStatus.OK);

        } catch (Exception e) {
            log.error("Error when recommending products by category: {}. error> {}", productCategory, e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "ByProductCategoryYearMonth",
            description = "List of recommended products by category, year and month",
            parameters = {
                    @Parameter(name = "productCategory", description = "productCategory", required = true, schema = @Schema(implementation = String.class)),
                    @Parameter(name = "year", description = "year", required = true, schema = @Schema(implementation = Integer.class)),
                    @Parameter(name = "month", description = "month", required = true, schema = @Schema(implementation = Integer.class))
            },
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200", description = "List of recommended products by category, year and month"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "400", description = "Error when recommending products by category, year and month")
            }
    )
    @GetMapping("/byProductCategory/{productCategory}/year/{year}/month/{month}")
    public ResponseEntity<List<EcommerceStatisticsDto>> byProductCategory(@PathVariable String productCategory,
                                                                          @PathVariable int year,
                                                                          @PathVariable int month) {
        try {
            log.info("Recomendando productos por categoria: {} year: {} month: {} ", productCategory, year, month);
            List<EcommerceStatisticsDto> productsRecommended =
                    service.recomendadosPorCategoriaMesAnio(productCategory, year, month);

            log.info(" {} ", gson.toJson(productsRecommended));

            return new ResponseEntity<List<EcommerceStatisticsDto>>(productsRecommended, HttpStatus.OK);

        } catch (Exception e) {
            log.error("Error al recomendar productos por categoria: {}.", productCategory, e);
            return ResponseEntity.badRequest().build();
        }
    }
}
