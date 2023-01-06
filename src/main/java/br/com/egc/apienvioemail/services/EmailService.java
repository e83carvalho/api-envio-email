package br.com.egc.apienvioemail.services;

import br.com.egc.apienvioemail.dtos.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(EmailDto emailDto) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDto.getEmailTo());
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getText());
        emailSender.send(message);

    }
}
