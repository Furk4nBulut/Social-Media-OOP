
package ooplab4.socailmedia;

import java.util.Date;

public class Main {


    public static void main(String[] args) {
        Date d = new Date();
        User user1 = new User("Furkan","Bulut","ToFuDuK","210316011","furkan",d,"male");
        User user2 = new User("Ahmet","Bulut","InfinityOfDeath","ahmet","ahmet",d,"male");

        user1.addFriend(user2);
        user2.addFriend(user1);
        user1.sendMessage("Merhaba",user2);
        user1.writeOutboxByIndex(0);
        user2.writeInboxByIndex(0);
    }
    
}
