package com.miempresa.mails;

import com.miempresa.entidades.Usuario;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.servlet.jsp.PageContext;

public class SendEmail {
  public String getRandom() {
    Random rnd = new Random();
    int number = rnd.nextInt(999999);
    return String.format("%06d", number);
  }
  
  public boolean sendEmail(Usuario usuario) {
    boolean test = false;
    String toEmail = usuario.getCorreo();
    String fromEmail = "aquesada.dlm@gmail.com";
    String password = "300915algdgadu";
    
    try {
      Properties pr = new Properties();
      pr.setProperty("mail.smtp.host", "smtp.gmail.com");;
      pr.setProperty("mail.smtp.port", "587");
      pr.setProperty("mail.smtp.auth", "true");
      pr.setProperty("mail.smtp.starttls.enable", "true");
      pr.setProperty("mail.smtp.socketFactory.port", "587");
      pr.setProperty("mail.smtpsocketFactory.class", "javax.net.ssl.SSLSocketFactory");
      // get session
      Session session = Session.getInstance(pr, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(fromEmail, password);
        }
      });
      
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(fromEmail));
      message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));    
      message.setSubject("¡Bienvenido a EntradasHoy 💖!");
      message.setContent("<p>code: "+usuario.getCode()+"</p>", "text/html");
      
      // send
      Transport.send(message);
      
      test = true;
      
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("DATA: SendEmail.java");
      System.out.println("Error: "+e);
      System.out.println("===================================================================================================");
    }
    
    return test;
  }
}
