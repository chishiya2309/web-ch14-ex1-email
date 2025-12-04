/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Properties;

import jakarta.mail.Address;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
/**
 *
 * @author lequa
 */
public class MailUtilGmail {
    public static void sendMail(String to, String from, String subject, String body, boolean bodyIsHTML) throws MessagingException {
        //1 - get a mail session
        Properties props = new Properties();
        // Cấu hình cho gmail qua ssl (port 456)
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        
        // Jakarta Mail tự động nhận diện implementation
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        // 2 - create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html; charset=UTF-8"); // Thêm charset UTF-8 để không lỗi font tiếng Việt
        } else {
            message.setText(body);
        }
        
        // 3 - address the message
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        
        //4 - send the message
        Transport transport = session.getTransport();
        transport.connect("lequanghung.work@gmail.com", "uavq yaam oomv cxvd");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
