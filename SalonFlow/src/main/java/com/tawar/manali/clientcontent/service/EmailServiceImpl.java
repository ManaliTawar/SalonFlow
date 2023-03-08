package com.tawar.manali.clientcontent.service;

import com.tawar.manali.clientcontent.model.Content;
import com.tawar.manali.clientcontent.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;
    private ContentRepository contentRepository;

    public EmailServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public String sendSimpleMail() {

        // Try block to check for exceptions
        try {
            List<Content> contents = contentRepository.findAllByBirthday(LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth());
            for (Content content : contents) {
                // Creating a simple mail message
                SimpleMailMessage mailMessage
                        = new SimpleMailMessage();

                // Setting up necessary details
                mailMessage.setFrom(sender);
                mailMessage.setTo(content.emailId());
                mailMessage.setText("Happy birthday");
                mailMessage.setSubject("Happy birthday");

                // Sending the mail
                javaMailSender.send(mailMessage);

            }
            return "Mail Sent Successfully...";
        }


            // Catch block to handle the exceptions
        catch(Exception e){
                return "Error while Sending Mail";
            }
        }


    @Override
    public String sendMailWithAttachment() {
        try {

        } catch (Exception e) {

        }
        return "Nothing Happended";
    }
}



