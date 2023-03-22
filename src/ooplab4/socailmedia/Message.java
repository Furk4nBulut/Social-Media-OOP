package ooplab4.socailmedia;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    public User sender;
    public User receiver;
    public String messageText;
    public Date date;
    public Message(User sender,User receiver,String messageText,Date date){
        this.sender = sender;
        this.receiver= receiver;
        this.messageText=messageText;
        this.date = date;
        receiver.receiveMessage(this);
    }
    public String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return  formatter.format(this.date);
    }
public String getMessageText(){
        return this.messageText;
}
public User getSender(){
        return this.sender;
}public User getReceiver(){
        return this.receiver;
}
}
