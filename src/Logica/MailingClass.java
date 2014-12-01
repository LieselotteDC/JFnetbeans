package Logica;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailingClass {

    public void sendRegistratiemail(Klant kl) {
        // Recipient's email ID needs to be mentioned.
        String to = kl.getEmail();

        // Sender's email ID needs to be mentioned
        final String username = "justfeedgroep01@gmail.com";
        final String password = "JustFeed01";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(username));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Welkom bij JUST-FEED!");

            // This mail has 3 parts, the bod, the embedded image and an attachment
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<font color='#FF9933' size='+2'>Welkom " + kl.getNaam() + " " + kl.getVoornaam() + ",</font>"
                    + "<P>bedankt voor je registratie bij Just-Feed!<br> "
                    + "Bij deze kennen we jou ook meteen een registratie-korting toe van 2 euro als blijk van waardering. <br>"
                    + "In de bijlage vind je meer info over de werking van onze dienst. "
                    + "Indien u nog vragen heeft, aarzel niet om ons te contacteren via het vooziene contactforumlier in ons programma.</P>"
                    + "<br><img src=\"cid:image\"> <br>"
                    + "<i><b>Het team van Just-Feed</b><br>"
                    + "<font color='#FFFFFF'>.........</font>De Coster Lieselotte<br>"
                    + "<font color='#FFFFFF'>.........</font>De Kerpel Laura<br>"
                    + "<font color='#FFFFFF'>.........</font>De Keyser Olivier<br>"
                    + "<font color='#FFFFFF'>.........</font>Hillewaere Menno<br>"
                    + "<font color='#FFFFFF'>.........</font>Pittoors Kimberley<br>"
                    + "<font color='#FFFFFF'>.........</font>Van der Poten Kelly<br>"
                    + "<a href=\"mailto:justfeedgroep01@gmail.com\">justfeedgroep01@gmail.com</a> <br> "
                    + "Project Beleidsinformatica, Prof. dr. Geert Poels, Begeleider Jan Claes</i>";
            messageBodyPart.setContent(htmlText, "text/html");
            // add it to the multipart
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            String filename1 = System.getProperty("user.dir"); //om de claspath overal te kunnen gebruiken
            filename1 += "\\src\\resizedlogo.png";
            DataSource fds = new FileDataSource(filename1);

            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            //third part (the attachment)
            messageBodyPart = new MimeBodyPart();
            String filename2 = System.getProperty("user.dir"); //om de claspath overal te kunnen gebruiken
            filename2 += "\\rapporten\\handleidingJustFeed.docx";
            DataSource source = new FileDataSource(filename2);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);
            // put everything together
            message.setContent(multipart);

            // Send message
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void contactKlantendienstemail(Klant kl, String onderwerp, String probleem) {
        // Recipient's email ID needs to be mentioned.
        String to = "klantendienstjustfeedgroep01@gmail.com";

        // Sender's email ID needs to be mentioned
        final String username = "justfeedgroep01@gmail.com";
        final String password = "JustFeed01";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(username));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(onderwerp);

            // This mail has 3 parts, the bod, the embedded image and an attachment
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<font color='#FF9933' size='+2'>Beste klantendienst,</font>"
                    + "<P>zouden jullie eens kunnen kijken naar het probleem van:<br> "
                    + "Naam klant: " + kl.getNaam() + " " + kl.getVoornaam() + "<br>"
                    + "E-mailadres: "
                    + "<a href=\"mailto:" + kl.getEmail() + "\">"+ kl.getEmail() +"</a> <br><br> "
                    + "Probleemomschrijving:<br>" + probleem + "<br>"
                    + "<br><img src=\"cid:image\"> <br>"
                    + "<i><b>Het team van Just-Feed</b><br>"
                    + "<font color='#FFFFFF'>.........</font>De Coster Lieselotte<br>"
                    + "<font color='#FFFFFF'>.........</font>De Kerpel Laura<br>"
                    + "<font color='#FFFFFF'>.........</font>De Keyser Olivier<br>"
                    + "<font color='#FFFFFF'>.........</font>Hillewaere Menno<br>"
                    + "<font color='#FFFFFF'>.........</font>Pittoors Kimberley<br>"
                    + "<font color='#FFFFFF'>.........</font>Van der Poten Kelly<br>"
                    + "<a href=\"mailto:justfeedgroep01@gmail.com\">justfeedgroep01@gmail.com</a> <br> "
                    + "Project Beleidsinformatica, Prof. dr. Geert Poels, Begeleider Jan Claes</i>";
            messageBodyPart.setContent(htmlText, "text/html");
            // add it to the multipart
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            String filename1 = System.getProperty("user.dir"); //om de claspath overal te kunnen gebruiken
            filename1 += "\\src\\resizedlogo.png";
            DataSource fds = new FileDataSource(filename1);

            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);

            // Send message
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
