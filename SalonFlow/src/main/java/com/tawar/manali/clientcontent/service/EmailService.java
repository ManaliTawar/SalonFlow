package com.tawar.manali.clientcontent.service;

import com.tawar.manali.clientcontent.model.EmailDetails;

public interface EmailService {
    //String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    //String sendMailWithAttachment(EmailDetails details);

    String sendSimpleMail();

    String sendMailWithAttachment();
}
