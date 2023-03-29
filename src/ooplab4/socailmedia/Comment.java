package ooplab4.socailmedia;

public class Comment {
    private User commenter;
    private String Text;
    private Post p;
    public Comment(User commenter, String Text , Post p){
        this.commenter= commenter;
        this.Text = Text;
        this.p = p;
    }

}

