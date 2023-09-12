package com.ventas.ecommerce.recommendation.service;

import com.ventas.ecommerce.recommendation.model.dto.EcommerceSales;
import com.ventas.ecommerce.recommendation.model.dto.EcommerceStatisticsDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * The type Ecommerce sales consumer.
 */
@Log4j2
@Service
public class EcommerceSalesConsumer {
    private final IEcommerceStatisticsService ecommerceStatisticsService;
    /**
     * The constant TOPIC.
     */
    public static final String TOPIC = "ecommerce_product_sales";
    /**
     * The constant GROUP_ID.
     */
    public static final String GROUP_ID = "groupId";

    /**
     * Instantiates a new Ecommerce sales consumer.
     *
     * @param ecommerceStatisticsService the ecommerce statistics service
     */
    public EcommerceSalesConsumer(IEcommerceStatisticsService ecommerceStatisticsService) {
        this.ecommerceStatisticsService = ecommerceStatisticsService;
    }

    /**
     * Listen group foo void.
     *
     * @param message the message
     * @param headers the headers
     * @return the void
     */
    @KafkaListener(topics = TOPIC, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void listenGroupFoo(@Payload EcommerceSales message, @Headers MessageHeaders headers) {
        try {
            log.info("Mensaje recibido del topic: {} gruopId: {} message: {} ", TOPIC, GROUP_ID, message);
            EcommerceStatisticsDto dto =
                    EcommerceStatisticsDto
                            .builder()
                            .year(message.getAnio())
                            .month(message.getMes())
                            .productCode(message.getProductCode())
                            .productCategory(message.getProductCategory())
                            .quantity(message.getQuantity())
                            .build();
            ecommerceStatisticsService.addEcommerceStatistics(dto);
        } catch (Exception e) {
            log.error("Error al procesar el mensaje: {} ", e.getMessage());
        }
    }
}
