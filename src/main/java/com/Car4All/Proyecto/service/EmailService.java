//package com.Car4All.Proyecto.service;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender emailSender;
//
//    @Autowired
//    private TemplateEngine templateEngine;
//
//    public void enviarCorreoConfirmacion(String email) {
//        MimeMessage message = emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        try {
//            helper.setTo(email);
//            helper.setSubject("Confirmación de registro");
//            String htmlContent = cargarTemplateConfirmacion();
//            helper.setText(htmlContent, true);
//        } catch (MessagingException e) {
//
//        }
//        emailSender.send(message);
//    }
//
//    private String cargarTemplateConfirmacion() {
//        Context context = new Context();
//        return templateEngine.process("confirmacionRegistro", context);
//    }
//    public void enviarCorreoConfirmacionReserva(String email) {
//        MimeMessage message = emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        try {
//            helper.setTo(email);
//            helper.setSubject("Confirmación de reserva");
//            String htmlContent = cargarTemplateReserva();
//            helper.setText(htmlContent, true);
//        } catch (MessagingException e) {
//
//        }
//        emailSender.send(message);
//    }
//    private String cargarTemplateReserva() {
//        Context context = new Context();
//        return templateEngine.process("confirmacionReserva", context);
//    }
//}
