package com.Decathlon.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

public class SendEmail {
    public static String filePath = (System.getProperty("user.dir")+"/src/test/resources/reports");

    public static String Path = filePath+"/Verification.xlsx";

    public static String value_date = LocalDate.now().toString();

    public static void sendEmail(String fromEmail, String FromEmailPassword, String toEmail,String siteTeste){

        String mailContent ="Bonjour, Ci-joint le fichier correspondant aux Retests sur le site " + siteTeste+"";
        // Receiver's email ID
        String receiver = toEmail; //"martinkuate9@gmail.com";

        // Sender's email ID
        String sender = fromEmail; //"martin.kuatepk67@gmail.com";

        // Sending email from gmail
        String host = "smtp.gmail.com";

        // Port of SMTP
        String port = "587";

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Create session object passing properties and authenticator instance
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, FromEmailPassword);
            }
        });

        try {
            // Create MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set the Senders mail to From
            message.setFrom(new InternetAddress(sender));

            // Set the recipients email address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

            // Subject of the email
            message.setSubject("Leetchi Retest");

            Multipart multipart = new MimeMultipart();

            // add the body message
            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText(mailContent);
            multipart.addBodyPart(bodyPart);

            // attach the file
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.attachFile(new File(Path));

            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

            // Send email.
            Transport.send(message);
            System.out.println("Mail sent successfully");
        } catch (MessagingException | IOException me) {
            me.printStackTrace();
        }
    }

    public static int mailParametersCheck(String fileName, String sheetName) throws IOException{
        //Create an object of File class to open xlsx file

        String os = System.getProperty("os.name");
        File fileToSend;
        if(os.startsWith("W")){
            fileToSend =    new File(filePath+"\\"+fileName);
        }else {
            fileToSend =    new File(filePath+"/"+fileName);
        }

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(fileToSend);

        Workbook guru99Workbook = null;

        //Find the file extension by splitting  file name in substring and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

            //If it is xlsx file then create object of XSSFWorkbook class

            guru99Workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

            guru99Workbook = new HSSFWorkbook(inputStream);

        }

        //Read excel sheet by sheet name

        Sheet sheet = guru99Workbook.getSheet(sheetName);

        // -----------  send mail  ----------
        int bugImplementNumber = 0;

        for (Row line : sheet) {       //browse lines
            for (Cell cell : line) {
                if (cell.getStringCellValue().contains(value_date)){

                    bugImplementNumber++;

                } //browse columns
            }
        }

        inputStream.close();

        return bugImplementNumber;
    }

    public static void sendEmailTo(String destination, String siteTeste) throws IOException {
            SendEmail.sendEmail("israeltestbox@gmail.com", "Qwerty0!", destination,siteTeste);
    }


}
