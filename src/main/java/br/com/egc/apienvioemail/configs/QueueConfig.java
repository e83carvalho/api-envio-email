package br.com.egc.apienvioemail.configs;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public Queue myQueue() {
        return new Queue("email", true);
    }


}
