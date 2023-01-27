package br.com.egc.apienvioemail.configs;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Value("${queue.email}")
    private String queueEmail;
    @Bean
    public Queue myQueue() {
        return new Queue(queueEmail, true);
    }


}
