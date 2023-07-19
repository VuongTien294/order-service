package tien.baseproject.orderservice.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonSerializer;
import tien.baseproject.orderservice.dto.kafka.MailMessageDTO;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Value(value = "${kafka.servers-config}")
    private String serversConfig;

    //Custom message producer
    @Bean
    public ProducerFactory<String, MailMessageDTO> producerFactory() {
        return new DefaultKafkaProducerFactory<>(getBaseProperties());
    }

    @Bean
    public KafkaTemplate<String, MailMessageDTO> mailMessageDTOKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    Map<String, Object> getBaseProperties() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                serversConfig);
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        return configProps;
    }
}
