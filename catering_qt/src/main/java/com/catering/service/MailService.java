package com.catering.service;

public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
    void sendHtmlMail(String to, String subject, String content);
    void sendAttachmentsMail(String to, String subject,String content, String filePath);

}
