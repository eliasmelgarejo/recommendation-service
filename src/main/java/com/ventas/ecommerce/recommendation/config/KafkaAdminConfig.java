package com.ventas.ecommerce.recommendation.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaAdminConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;
    @Value(value = "${kafka.topic}")
    private String TOPIC;
    @Value(value = "${kafka.num-partitions}")
    private int NUM_PARTITIONS;
    @Value(value = "${kafka.replication-factor}")
    private short REPLICATION_FACTOR;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    //if you don't have any topic created
    //this bean will see if there's a topic already created, if not, it will create it
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic(TOPIC, NUM_PARTITIONS, REPLICATION_FACTOR);
    }
}
