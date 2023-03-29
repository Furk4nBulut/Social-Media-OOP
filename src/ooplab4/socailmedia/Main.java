
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
       Post p = new Post(user1,"Hi!","Url");
          user1.addPost("hello","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftzeyang.com%2Fwp-content%2Fuploads%2F2018%2F03%2FHello.jpg.png&f=1&nofb=1&ipt=4ffd3782415aa99c2bd27c2556406fecb0ad20e2081370cb6b055b0eccfd212c&ipo=images");
        user1.sendMessage("Postumum beğenip like atar mısın? :)",user2);

        user1.addComment(p,"yorum");
        user2.Like(p);
        user1.writeOutboxByIndex(0);
        user2.writeInboxByIndex(0);
    }
    
}
