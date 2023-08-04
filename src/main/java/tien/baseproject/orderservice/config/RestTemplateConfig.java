package tien.baseproject.orderservice.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate webClientBuilder() {
        return new RestTemplate();
    }

    //@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //Một bean với prototype scope sẽ trả về các instance khác nhau mỗi khi có một
    //yêu mới sử dụng chúng đến IoC container.
}
