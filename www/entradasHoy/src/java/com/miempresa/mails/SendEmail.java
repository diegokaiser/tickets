package com.miempresa.mails;

import com.miempresa.entidades.Usuario;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

public class SendEmail {
  public String getRandom() {
    Random rnd = new Random();
    int number = rnd.nextInt(999999);
    return String.format("%06d", number);
  }
  
  public boolean sendEmail(Usuario usuario, HttpServletRequest request) {
    boolean test = false;
    String toEmail = usuario.getCorreo();
    String toUName = usuario.getNombre();
    String fromEmail = "aquesada.dlm@gmail.com";
    String password = "300915algdgadu";
    String URI = request.getContextPath();
    String URIimages = URI+"RESOURCES/images";
    
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
      message.setFrom(new InternetAddress(fromEmail, "Solo Estrenos"));
      message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));    
      message.setSubject("¡Bienvenido a EntradasHoy!");
      message.setContent(""
              + "<body style=\"margin:0; padding:0; background-color:#F2F2F2;\">"
              + "<span style=\"display: block; color: #F2F2F2; width: 640px !important; max-width: 640px; height: 1px\" class=\"mobileOff\">Necesitamos que valides tu correo electrónico</span>"
              + "<center>"
              + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#F2F2F2\">"
              + "<tr>"
              + "<td align=\"center\" valign=\"top\">"
              + "<tr>"
              + "<td align=\"center\" valign=\"top\">"
              + "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"wrapper\" bgcolor=\"#191919\">"
              + "<tr>"
              + "<td align=\"center\" bgcolor=\"#191919\" valign=\"middle\">"
              + "<img alt=\"EstrenosHoy\" class=\"img\" src="+URIimages+"/mail_header.jpg\">"
              + "</td>"
              + "</tr>"
              + "</table>"
              + "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"wrapper\" bgcolor=\"#000000\">"
              + "<tr>"
              + "<td align=\"center\" valign=\"top\">"
              + "<table width=\"540\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"container\">"
              + "<tr>"
              + "<td height=\"35\" style=\"font-size:35px; line-height:35px;\">&nbsp;</td>"
              + "</tr>"
              + "</table>"
              + "<table width=\"540\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"container\">"
              + "<tr>"
              + "<td align=\"left\" valign=\"top\">"
              + "<p class=\"fonta\" style=\"font-family: Arial, Helvetica, sans-serif; font-weight:bold; font-size: 15px; line-height: 18px; color: #e50914;\">Bienvenido "+toUName+"!</p>"
              + "<p class=\"fonta\" style=\"font-family: Arial, Helvetica, sans-serif; font-size: 14px; line-height: 18px; color: #d1d0cf;\">Estamos contentos de tenerte abordo. En EstrenosHoy puedes conseguir entradas a los estrenos de las películas que tanto esperas y en venta directa con quienes manejan el evento de estreno.</p>"
              + "</td>"
              + "</tr>"
              + "</table>"
              + "<table width=\"540\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"container\">"
              + "<tr>"
              + "<td align=\"left\" valign=\"top\">"
              + "<p class=\"fonta\" style=\"font-family: Arial, Helvetica, sans-serif; font-size: 14px; line-height: 18px; color: #d1d0cf;\">Necesitamos que valides la propiedad el correo electrónico de la cuenta que has creado:</p>"
              + "<p class=\"fonta\" style=\"font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: bold; line-height: 18px; color: #d1d0cf; text-align: center;\">"
              + "<a style=\"background-color: #e50914; border-radius: 4px; color: #d1d0cf; display: inline-block; padding: 11px 28px; text-decoration: none;\" href="+URI+"/UsuarioController?processing=validarUsuario&Correo="+toEmail+">"
              + "Validar correo electrónico"
              + "</a>"
              + "</p>"
              + "</td>"
              + "</tr>"
              + "</table>"
              + "<table width=\"540\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"container\">"
              + "<tr>"
              + "<td height=\"21\" style=\"font-size:21px; line-height:21px;\">&nbsp;</td>"
              + "</tr>"
              + "</table>"
              + "<table width=\"540\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"container\">"
              + "<tr>"
              + "<td align=\"left\" valign=\"top\">"
              + "<p class=\"fonta\" style=\"font-family: Arial, Helvetica, sans-serif; font-size: 14px; line-height: 18px; color: #d1d0cf;\">Atentamente,<br> El equipo de EstrenosHoy</p>"
              + "</td>"
              + "</tr>"
              + "</table>"
              + "<table width=\"540\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"container\">"
              + "<tr>"
              + "<td height=\"35\" style=\"font-size:35px; line-height:35px;\">&nbsp;</td>"
              + "</tr>"
              + "</table>"
              + "</tr>"
              + "</table>"
              + "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"wrapper\" bgcolor=\"#191919\">"
              + "<tr>"
              + "<td style=\"font-size: 0px; line-height: 0px;\" valign=\"top\"></td>"
              + "</tr>"
              + "<tr>"
              + "<td align=\"center\" valign=\"top\">"
              + "<table width=\"540\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"container\">"
              + "<tr>"
              + "<td height=\"14\" style=\"font-size:14px; line-height:14px;\">&nbsp;</td>"
              + "</tr>"
              + "<tr>"
              + "<td align=\"left\" valign=\"top\">"
              + "<p class=\"fonta\" style=\"font-family: Arial, Helvetica, sans-serif;font-size: 12px; line-height: 16px; color: #e50914;\">© EstrenosHoy<br>2021 - Todos los derechos reservados</p>"
              + "</td>"
              + "</tr>"
              + "<tr>"
              + "<td height=\"14\" style=\"font-size:14px; line-height:14px;\">&nbsp;</td>"
              + "</tr>"
              + "</table>"
              + "</td>"
              + "</tr>"
              + "</table>"
              + "</td>"
              + "</tr>"
              + "</table>"
              + "</center>"
              + "</body>", "text/html");
      // message.setContent("<p><a href="+URI+"/UsuarioController?proccesing=validarUsuario&Correo="+toEmail+">Link</a></p>", "text/html");
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
