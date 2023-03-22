package ooplab4.socailmedia;

import java.util.Date;

public class User {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String username;
    private Date birthdate;
    private String gender;
    private  User[] friends;
    private  int friendsCount;
    private  Message[] inbox;
    private  Message[] outbox;

    private int inboxCount;
    private  int outBoxCount;


    public User(String name,String surname, String username,String email,String password,Date birthdate,String gender){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.birthdate =birthdate;
        this.gender = gender;
        this.friends =new  User[10];
        this.inbox = new Message[10];
        this.outbox = new Message[10];
    }
    public void addFriend(User u){
        if(this.friendsCount == this.friends.length){
            User tempArray[] = this.friends;
            friends = new User[2*this.friends.length];
            for(int i =0;i<tempArray.length;i++)
            {
                friends[i] =tempArray[i];

            }
        }

    }
    public void sendMessage(String messageText, User receriver){
        Date d = new Date();
        Message m = new Message(this,receriver,messageText,d);
        if(outBoxCount == this.outbox.length){
            Message tempMsgs[] = this.outbox;
            this.outbox = new Message[2*this.outbox.length];
            for (int i =0; i<tempMsgs.length;i++){
                this.outbox[i]=tempMsgs[i];
            }
        }
        this.outbox[this.outBoxCount] = m;
        this.outBoxCount++;
    }
    public void receiveMessage(Message m) { // ödevde ekstra 5 puan kazandıran kod!
        if (inboxCount == (this.inbox.length-1)) {
            Message tempMsgs[] = this.inbox;
            this.inbox = new Message[2*this.inbox.length];
            for (int i = 0; i < tempMsgs.length; i++) {
                this.inbox[i] = tempMsgs[i];
            }
        }
        this.inbox[this.inboxCount] = m;
        this.inboxCount++;
    }
    public void writeInboxByIndex (int i ) {
        if ( i >= this.inboxCount){
            System.out.println("Error!");
        }
        else {
            System.out.println("Date:"+inbox[i].getDate());
            System.out.println("Sender:"+inbox[i].getSender().getEmail());
            System.out.println("Message:"+inbox[i].getMessageText());
        }
    }
    public void writeOutboxByIndex(int i){
        if (i >= this.outBoxCount){
            System.out.println();
        }else{
            System.out.println("Date:"+outbox[i].getDate());
            System.out.println("Receiver:"+outbox[i].getReceiver().getEmail());
            System.out.println("Message:"+outbox[i].getMessageText());
        }

    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }


}
