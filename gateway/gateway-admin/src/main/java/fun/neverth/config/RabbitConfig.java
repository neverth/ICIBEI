package fun.neverth.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo
 *
 * @author NeverTh
 * @date 2020/7/12 11:52
 */
@Configuration
@Slf4j
public class RabbitConfig {

    public static final String QUEUE_NAME = "icibei-event-gateway";
    public static final String EXCHANGE_NAME = "icibei-exchange";
    public static final String ROUTING_KEY = "icibei-gateway-route";

    @Bean
    Queue queue() {
        log.info("queue name:{}", QUEUE_NAME);
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    TopicExchange exchange() {
        log.info("exchange:{}", EXCHANGE_NAME);
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        log.info("binding {} to {} with {}", queue, exchange, ROUTING_KEY);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    /**
     * 定义消息转换器直接发送对象
     */
    @Bean
    public MessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        return new ContentTypeDelegatingMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
    }

}