package util;

import java.util.Properties;
import jakarta.mail.Address;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
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
        
        // --- 1. LẤY THÔNG TIN TỪ BIẾN MÔI TRƯỜNG ---
        // Lưu ý: Tên biến (trong ngoặc kép) phải khớp chính xác với cấu hình trên Render
        final String emailUser = System.getenv("EMAIL_USERNAME");
        final String emailPass = System.getenv("EMAIL_PASSWORD");

        // Kiểm tra xem biến có tồn tại không (để debug lỗi nhanh hơn)
        if (emailUser == null || emailPass == null) {
            System.out.println("ERROR: Chưa cấu hình biến môi trường EMAIL_USERNAME hoặc EMAIL_PASSWORD trên Render!");
        }

        // --- 2. CẤU HÌNH PROPERTIES (Port 587) ---
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // --- 3. TẠO SESSION VỚI AUTHENTICATOR ---
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // Sử dụng biến đã lấy ở trên thay vì hardcode
                return new PasswordAuthentication(emailUser, emailPass);
            }
        });
        
        session.setDebug(true); // Bật log để theo dõi trên Render Dashboard

        // --- 4. TẠO MESSAGE ---
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        
        if (bodyIsHTML) {
            message.setContent(body, "text/html; charset=UTF-8");
        } else {
            message.setText(body);
        }

        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // --- 5. GỬI MAIL ---
        Transport.send(message);
    }
}