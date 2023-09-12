package com.ventas.ecommerce.recommendation;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;
import com.ventas.ecommerce.recommendation.model.dto.EcommerceStatisticsDto;
import com.ventas.ecommerce.recommendation.model.entity.EcommerceStatistics;
import com.ventas.ecommerce.recommendation.service.IEcommerceStatisticsService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Log4j2
@SpringBootTest
class RecommendationServiceApplicationTests {

	@Autowired
	private IEcommerceStatisticsService service;
	@Autowired
	private Gson gson;

	@Test
	void contextLoads() {
		List<EcommerceStatisticsDto> recomendadosPorCategoria = service.recomendadosPorCategoria("1");
		log.info(" {} ", gson.toJson(recomendadosPorCategoria));
		log.info(" {} ", recomendadosPorCategoria);
		assert(recomendadosPorCategoria.size() > 0);
	}

}
