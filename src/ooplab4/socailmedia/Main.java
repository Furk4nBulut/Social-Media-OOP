
package ooplab4.socailmedia;

import java.util.Date;

public class Main {


    public static void main(String[] args) {
        Date d = new Date();
        User u1 = new User("aaa","aaa","aaa","aaa","aaa",d,"aaaa");
        User u2 = new User("bbb","bbb","bbb","bbb","bbb",d,"bbb");
        u1.addFriend(u2);
        u2.addFriend(u1);
        u1.sendMessage("Deneme",u2);
        u2.writeInboxByIndex(0);
        u1.writeOutboxByIndex(0);
    }
    
}
