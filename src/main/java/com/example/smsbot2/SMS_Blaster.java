package com.example.smsbot2;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SMS_Blaster {

    private static final String ACCOUNT_SID = "ACcd6898ea24ec86a9578dce45f377f1d5";//System.getenv("TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = "b36f72906d724a2e25ac4c44840e0f24";//System.getenv("TWILIO_AUTH_TOKEN");
    File phoneNumbers;

    private String messageText = "default Message";

    public void load(){
        phoneNumbers = new FileChooser().showOpenDialog(null);
    }

    public void setMessage(String newText){
        messageText = newText;
    }


    public void sendMessage(String to) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+1" + to),
                        new com.twilio.type.PhoneNumber("+13139924418"),
                        messageText)
                .create();
    }

    public void CSV_parseAndSend(){
        //inits scanner and preps scanner for looping
        try (Scanner scanner = new Scanner(phoneNumbers)) {
            String current = scanner.nextLine();
            current = scanner.nextLine();
            boolean go = true;
            while (go) {
                //System.out.println(current);
                //substringing just the phone number out
                char lookingForComma = 'a';
                int commaIndex = 0;
                for (int i = 0 ; lookingForComma != ',' && i < current.length() ; i++ ) {
                    lookingForComma = current.charAt(i);
                    if (lookingForComma == ',') {
                        commaIndex = i;
                    }
                }
                String number = current.substring( commaIndex + 1 );
                System.out.println(number);

                this.sendMessage(number);
                System.out.println("sent");

                if ( scanner.hasNext() == false ){
                    go = false;
                    break;
                }
                current = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("there's noting to shoot");
            return;
        } catch (NullPointerException n) {
            System.out.println("null pointer exe");
        }

//        while(){
//            //reads the next number in the scanner and then runs sendMessage() on it
//
//
//        }


    }

}
