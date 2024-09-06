/**
 * @author :  Dinuth Dheeraka
 * Created : 8/8/2023 9:59 AM
 */
package com.ceyentra.sm.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Component
@Log4j2
@RequiredArgsConstructor
public class EmailSender {

    private final JavaMailSender javaMailSender;

    @Value(value = "${mail.from}")
    private String mailFrom;

    public void sendEmail(MimeMessage mimeMessage) throws MessagingException {
        log.info("start function sendEmail");
        try {

            javaMailSender.send(mimeMessage);

        } catch (Exception e) {
            log.error("function sendEmail {}", e.getMessage(), e);
            throw e;
        }

    }

    public void sendSimpleEmail(String recipient, String subject, String content) throws MessagingException {
        log.info("Start function sendSimpleEmail @Param recipient : {} @Param subject : {}", recipient, subject);
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            message.setFrom(mailFrom);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);

            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(content, "text/html; charset=utf-8");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            sendEmail(message);

            log.info("Email successfully dispatched.");

        } catch (MessagingException e) {
            log.error("Function sendSimpleEmail  : {}", e.getMessage(), e);
            throw e;
        }
    }

}
