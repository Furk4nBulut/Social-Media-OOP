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

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Post getP() {
        return p;
    }

    public void setP(Post p) {
        this.p = p;
    }

}

