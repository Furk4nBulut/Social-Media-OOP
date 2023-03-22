
package ooplab4.socailmedia;

import java.util.Date;

public class Main {


    public static void main(String[] args) {
        Date d = new Date();
        User u1 = new User("Furkan","Bulut","ToFuDuK","210316011","furkan",d,"male");
        User u2 = new User("Ahmet","Bulut","InfinityOfDeath","ahmet","ahmet",d,"male");
        u1.addFriend(u2);
        u2.addFriend(u1);
        u1.sendMessage("Nabıyon be ya?\n",u2);
        u2.writeInboxByIndex(0);
        u1.writeOutboxByIndex(0);
        u2.sendMessage("Sanane\n",u1);
        u1.writeInboxByIndex(0);
        u2.writeOutboxByIndex(0);
    }
    
}
