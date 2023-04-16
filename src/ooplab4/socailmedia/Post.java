package ooplab4.socailmedia;

public class Post {
    private User poster;
    private String text ;
    private String mediaUrl;
    private User[] likers;
    private Comment[] comments;
    private int likersCount;
    private int commentCount;
    private int postCount;


    public Post(User poster,String text,String mediaUrl){
        this.poster = poster;
        this.text = text;
        this.mediaUrl = mediaUrl;
        this.likers = new User[10];
        this.comments = new Comment[10];
        this.likersCount = 0;
        this.commentCount =0;
    }
    public void addLike(User liker){
        if(this.likersCount == this.likers.length){
            User tempArray[] = this.likers;
            likers = new User[2*this.likers.length];
            for(int i =0;i<tempArray.length;i++)
            {
                likers[i] =tempArray[i];

            }
        }
        this.likers[likersCount] = liker;
    }
    public void addComment(Comment c){
        if(this.commentCount == this.comments.length){
            Comment tempArray[] = this.comments;
            comments  = new Comment[2*this.commentCount];
            for(int i =0;i<tempArray.length;i++)
            {
                comments[i] =tempArray[i];

            }
        }
        this.comments[commentCount] = c;
        this.commentCount++;
    }
    public String getPost(Post post){
        String postformat = text + mediaUrl;
        return  postformat;
    }

}
