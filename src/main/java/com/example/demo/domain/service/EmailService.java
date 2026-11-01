package com.example.demo.domain.service;


import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${app.mail.from}")
    private String remetente;


    public void enviarEmail(String destinatario, String token){
        var message = new SimpleMailMessage();
        message.setFrom(remetente);
        message.setTo(destinatario);
        message.setSubject("Recuperação de Senha - Sistema");
        message.setText("Olá,\n\n Recebemos um pedido para redefinir a sua senha.\n\n" +
                "O seu token de recuperação é: " + token + "\n\n" +
                "Utilize este token na aplicação para definir uma nova senha. Ele expira em 15 minutos.\n\n" +
                "Se não foi você que solicitou, ignore este e-mail.");

        javaMailSender.send(message);
    }
}
