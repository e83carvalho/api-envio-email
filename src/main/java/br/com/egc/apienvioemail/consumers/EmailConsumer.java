package br.com.egc.apienvioemail.consumers;

import br.com.egc.apienvioemail.dtos.EmailDto;
import br.com.egc.apienvioemail.services.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "email")
    public void listen(@Payload String message) {
        log.info("receiving message");

        try {
            EmailDto emailDto = new ObjectMapper().readValue(message, EmailDto.class);
            emailService.sendEmail(emailDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
