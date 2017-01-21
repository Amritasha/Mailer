import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class SendM {

    public static void main(String[] args){

        String to = "#email"; //recipient email

        Properties props = new Properties();

        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");

        //connecting
        Session session = Session.getDefaultInstance(props ,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication("#email","#password"); //enter email and password
                    }
                });

        //compose msg
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("#email")); //email
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Hello");
            message.setText("Email sent by java program testing");

            //send msg
            Transport.send(message);
            System.out.println("sent success");
        }catch(MessagingException e){
            throw new RuntimeException(e);
        }
    }
}

