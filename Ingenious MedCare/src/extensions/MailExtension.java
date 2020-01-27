package extensions;
import javax.mail.internet.*;
import javax.mail.*;
import java.util.*;

public class MailExtension {
	
	public static void sendMessage() {
	    // 1 -> Création de la session
	    Properties properties = new Properties();
	    properties.setProperty("mail.transport.protocol", "smtp");
	    properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	    properties.setProperty("mail.smtp.starttls.enable", "true");
	    properties.setProperty("mail.smtp.user", "ingeniousmedcare@gmail.com");
	    properties.setProperty("mail.from", "ingeniousmedcare@gmail.com");
	    Session session = Session.getInstance(properties);
	    // 2 -> Création du message
	    MimeMessage message = new MimeMessage(session);
	    try {
	        message.setText("Vous devez remettre du stock sinon c'est chaud !");
	        message.setSubject("C'est la merde dans les stock");
	        message.addRecipients(Message.RecipientType.TO, "ingeniousmedcare@gmail.com");
	        //message.addRecipients(Message.RecipientType.CC, copyDest);
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	    // 3 -> Envoi du message
	    Transport transport = null;
	    try {
	        transport = session.getTransport("smtp");
	        transport.connect("ingeniousmedcare@gmail.com", "ingeniousmedcare2020");
	        transport.sendMessage(message, new Address[] { new InternetAddress("ingeniousmedcare@gmail.com"),
	        });
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (transport != null) {
	                transport.close();
	            }
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	}
	
}
