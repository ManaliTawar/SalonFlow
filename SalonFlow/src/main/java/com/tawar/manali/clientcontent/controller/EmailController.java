package com.tawar.manali.clientcontent.controller;

import com.tawar.manali.clientcontent.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Sending a simple Email
    @GetMapping("/sendMail")
    public String
    sendMail()
    {
        String status
                = emailService.sendSimpleMail();

        return status;
    }

    // Sending email with attachment
    @GetMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            )
    {
        String status
                = emailService.sendMailWithAttachment();

        return status;
    }
}
