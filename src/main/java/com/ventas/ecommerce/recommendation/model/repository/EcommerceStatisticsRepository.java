package com.ventas.ecommerce.recommendation.model.repository;

import com.ventas.ecommerce.recommendation.model.entity.EcommerceStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EcommerceStatisticsRepository extends JpaRepository<EcommerceStatistics, Long> {
    @Query("select (count(e) > 0) from EcommerceStatistics e where e.productCode = ?1 and e.year = ?2 and e.month = ?3")
    boolean ExistsProduct(String productCode, int year, int month);

    Optional<EcommerceStatistics> findFirstByProductCodeAndYearAndMonthOrderByIdDesc(String productCode, int year, int month);

    //select  * from ecommerce_statistics es order by es.quantity desc limit 3
    @Query(value = "select  e.id, e.created_dated, e.\"month\", e.product_code,\n" +
            "e.product_category, sum(e.quantity) as \"quantity\",\n" +
            "e.updated_dated, e.\"version\", e.\"year\" \n" +
            "from ecommerce_statistics e \n" +
            "where e.product_category = ?1\n" +
            "group by e.id, e.created_dated, e.\"month\", \n" +
            "e.product_code, e.product_category, \"quantity\", \n" +
            "e.updated_dated, e.\"version\", e.\"year\" \n" +
            "order by e.quantity desc \n" +
            "limit 3 ",
            nativeQuery = true)
    List<EcommerceStatistics> recomendadosPorCategoria(String productCategory);

    @Query("""
            select e from EcommerceStatistics e
            where e.productCategory = ?1 and e.year = ?2 and e.month = ?3
            order by e.quantity DESC LIMIT 3""")
    List<EcommerceStatistics> recomendadosPorCategoriaMesAnio(String productCategory, int year, int month);

}