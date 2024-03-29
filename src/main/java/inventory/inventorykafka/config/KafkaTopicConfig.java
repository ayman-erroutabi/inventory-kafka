package inventory.inventorykafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

import static inventory.inventorykafka.constants.KafkaConstants.KAFKA_TOPIC_ORDERS;
import static inventory.inventorykafka.constants.KafkaConstants.KAFKA_TOPIC_ORDERS_PROCESSED;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topicOrders() {
        return TopicBuilder.name(KAFKA_TOPIC_ORDERS).build();
    }

    @Bean
    public NewTopic topicOrdersProcessed() {
        return TopicBuilder.name(KAFKA_TOPIC_ORDERS_PROCESSED).build();
    }
}