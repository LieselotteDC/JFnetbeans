package Logica;

import Database.Database;
import java.util.ArrayList;
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

    public void sendRegistratiemailKlant(Klant kl) {
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
            filename2 += "\\rapporten\\handleidingJustFeed.pdf";
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
                    + "<a href=\"mailto:" + kl.getEmail() + "\">" + kl.getEmail() + "</a> <br><br> "
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

    public void sendAwardemail(String takeaway, String bestandsnaam) {
        // Recipient's email ID needs to be mentioned.
        Database d = new Database();
        String to = d.getTakeaway(takeaway).getEmail();

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
            message.setSubject("Infobericht maandelijkse awards");

            // This mail has 3 parts, the bod, the embedded image and an attachment
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<font color='#FF9933' size='+2'>Beste " + takeaway + ",</font>"
                    + "<P>In bijlage vindt u de uitgereikte awards van de voorbije maand.<br> "
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
            filename2 += "\\rapporten\\" + bestandsnaam;
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

    public void sendRegistratiemailTakeaway(Take_Away ta) {
        // Recipient's email ID needs to be mentioned.

        String to = ta.getEmail();

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
            String htmlText = "<font color='#FF9933' size='+2'>Welkom " + ta.getNaam() + ",</font>"
                    + "<P>Bedankt voor je registratie bij Just-Feed!<br> "
                    + "Als service bieden wij u de mogelijkheid aan om alle extra gegevens via ons toe te voegen.<br>"
                    + "Daarvoor dient u enkel een e-mail naar ons te sturen met de nodige gegevens.<br>"
                    + "Wij zorgen er dan voor dat al uw gegevens in het programma terecht komen.<br>"
                    + "Alvorens klanten producten bij u kunnen bestellen, moet u minsten één vestiging en product toevoegen.<br>"
                    + "Indien u nog vragen heeft, aarzel niet om ons te contacteren via onderstaand email-adres.</P>"
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

    public void sendHerinneringReviewmail(Klant kl) {
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
            message.setSubject("Herinnering review!");

            // This mail has 3 parts, the bod, the embedded image and an attachment
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<font color='#FF9933' size='+2'>Beste " + kl.getNaam() + " " + kl.getVoornaam() + ",</font>"
                    + "<P>Bedankt voor het plaatsen van een order!<br> "
                    + "Vergeet niet dat je binnen de 7 dagen een review per product kan schrijven.<br>"
                    + "Per product dat je de eerste keer beoordeelt (uiteraard binnen de 7 dagen), krijg je een review korting.</P>"
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

    public void sendBesteldeProductenVanOrder(Take_Away takeaway, String bestandsnaam) {
        // Recipient's email ID needs to be mentioned.
        //System.out.println(takeaway.getEmail());
       // String to = takeaway.getEmail();
        String to = "menno.hillewaere@gmail.com";
        
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
            message.setSubject("Overzicht van bestelling");

            // This mail has 3 parts, the bod, the embedded image and an attachment
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<font color='#FF9933' size='+2'>Beste, " + takeaway.getNaam() + ",</font>"
                    + "<P>Er is zonet een menu besteld bij een vestiging van uw takeaway!<br> "
                    + "In de bijlage vindt u de bestelbon met de nodige informatie.<br>"
                    + "Indien u vragen heeft over deze bestelling, aarzel dan niet om ons te contacteren<br>"
                    + "op het onderstaande e-mailadres</P>"
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
            filename2 += "\\rapporten\\" + bestandsnaam;
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

    public void sendCommissiemail(Take_Away ta, String maand, int jaar, double bedrag) {
        // Recipient's email ID needs to be mentioned.

        String to = ta.getEmail();

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
            message.setSubject("Commissie " + maand + " " + jaar);

            // This mail has 3 parts, the bod, the embedded image and an attachment
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<font color='#FF9933' size='+2'>Beste " + ta.getNaam() + ",</font>"
                    + "<P>De commissie van " + maand + " " + jaar + " bedraagt: " + bedrag + " euro.<br> "
                    + "Gelieve dit te storten op BE53001496589253 voor het einde van de maand!"
                    + "Indien u vragen heeft over deze berekeningen, aarzel dan niet om ons te contacteren<br>"
                    + "op het onderstaande e-mailadres</P>"
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

    public void sendMenukaartmail(String takeaway, String bestandsnaam) {
        {
            // Recipient's email ID needs to be mentioned.
            Database d = new Database();
            String to = d.getTakeaway(takeaway).getEmail();

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
                message.setSubject("Menukaart");

                // This mail has 3 parts, the bod, the embedded image and an attachment
                MimeMultipart multipart = new MimeMultipart("related");

                // first part (the html)
                BodyPart messageBodyPart = new MimeBodyPart();
                String htmlText = "<font color='#FF9933' size='+2'>Beste " + takeaway + ",</font>"
                        + "<P>In bijlage vindt u de aangevraagde menukaart van uw takeaway.<br> "
                        + "Indien u hierover vragen hebt, aarzel niet om ons te contacteren op onderstaand e-mailadres!</P>"
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
                filename2 += "\\rapporten\\" + bestandsnaam;
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
    }

    public void sendLopendeOrdersmail(String takeaway, String bestandsnaam) {
        {
            // Recipient's email ID needs to be mentioned.
            Database d = new Database();
            String to = d.getTakeaway(takeaway).getEmail();

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
                message.setSubject("Lopende orders");

                // This mail has 3 parts, the bod, the embedded image and an attachment
                MimeMultipart multipart = new MimeMultipart("related");

                // first part (the html)
                BodyPart messageBodyPart = new MimeBodyPart();
                String htmlText = "<font color='#FF9933' size='+2'>Beste " + takeaway + ",</font>"
                        + "<P>In bijlage vindt u de aangevraagde lopende orders van uw takeaway.<br> "
                        + "Indien u hierover vragen hebt, aarzel niet om ons te contacteren op onderstaand e-mailadres!</P>"
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
                filename2 += "\\rapporten\\" + bestandsnaam;
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

    }

    public void sendVerkopenmail(String takeaway, String bestandsnaam) {

        // Recipient's email ID needs to be mentioned.
        Database d = new Database();
        String to = d.getTakeaway(takeaway).getEmail();

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
            message.setSubject("Verkopen");

            // This mail has 3 parts, the bod, the embedded image and an attachment
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<font color='#FF9933' size='+2'>Beste " + takeaway + ",</font>"
                    + "<P>In bijlage vindt u de aangevraagde verkopen van uw takeaway.<br> "
                    + "Indien u hierover vragen hebt, aarzel niet om ons te contacteren op onderstaand e-mailadres!</P>"
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
            filename2 += "\\rapporten\\" + bestandsnaam;
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

    public void sendLopendeUniekeKortingscodesmail(String takeaway, String bestandsnaam) {
        // Recipient's email ID needs to be mentioned.
        Database d = new Database();
        String to = d.getTakeaway(takeaway).getEmail();

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
            message.setSubject("Lopende unieke kortingscodes");

            // This mail has 3 parts, the bod, the embedded image and an attachment
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<font color='#FF9933' size='+2'>Beste " + takeaway + ",</font>"
                    + "<P>In bijlage vindt u de aangevraagde lopende unieke"
                    + "(zowel eenmalige als periodieke)kortingen van uw takeaway.<br> "
                    + "Indien u hierover vragen hebt, aarzel niet om ons te contacteren op onderstaand e-mailadres!</P>"
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
            filename2 += "\\rapporten\\" + bestandsnaam;
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
}
