/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.service.sec;

import com.google.api.services.gmail.model.Message;
import com.id.sigada.config.GmailApiUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Afes
 */
@Service
public class MailService {

    @Value("${gmail.account.username}")
    private String mailUsername;

    @Value("${gmail.account.personal}")
    private String mailPersonal;

    @Autowired
    private GmailApiUtil gmailApiUtil;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void send(String recipient, String subject, String content) throws MessagingException, UnsupportedEncodingException, IOException {
        MimeMessage m = gmailApiUtil.createEmail(recipient, mailUsername, mailPersonal, subject, content);
        Message message = gmailApiUtil.createMessageWithEmail(m);
        message = gmailApiUtil.getGmailService().users().messages().send(mailUsername, message).execute();
        logger.debug("message : " + message.toPrettyString());
        logger.debug("messages in users : " + gmailApiUtil.getGmailService().users().messages().list(mailUsername).size());
    }
}
