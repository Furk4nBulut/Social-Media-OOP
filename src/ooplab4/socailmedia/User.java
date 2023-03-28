package ooplab4.socailmedia;

import java.util.Arrays;
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
    public Message[] getOutbox() {
        return Arrays.copyOf(outbox, outBoxCount);
    }
    public Message[] getInbox() {
        return inbox;
    }

    public int getMessageIndex(Message[] messages, Message message) {
        for (int i = 0; i < messages.length; i++) {
            if (messages[i] == message) {
                return i;
            }
        }
        return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User[] getFriends() {
        return friends;
    }

    public void setFriends(User[] friends) {
        this.friends = friends;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public void setInbox(Message[] inbox) {
        this.inbox = inbox;
    }

    public void setOutbox(Message[] outbox) {
        this.outbox = outbox;
    }

    public int getInboxCount() {
        return inboxCount;
    }

    public void setInboxCount(int inboxCount) {
        this.inboxCount = inboxCount;
    }

    public int getOutBoxCount() {
        return outBoxCount;
    }

    public void setOutBoxCount(int outBoxCount) {
        this.outBoxCount = outBoxCount;
    }
}
