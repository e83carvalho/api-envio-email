package br.com.egc.apienvioemail.configs;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class QueueConfig {

    @Value("${queue.email}")
    private String queueEmail;
    @Bean
    public Queue myQueue() {
        log.info("registrando a fila :" +queueEmail);
        return new Queue(queueEmail, true);
    }


}
