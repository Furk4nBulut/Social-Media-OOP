package ooplab4.socailmedia;

public class Post {
    private User poster;
    private String text ;
    private String mediaUrl;
    private User[] likers;
    private Comment[] comments;
    private int likersCount;
    private int commentCount;


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
        likersCount++;
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


    public void showComments() {
        System.out.printf("\t%d comments:\n", commentCount);
        for (int i = 0; i < commentCount; i++) {
            Comment c = comments[i];
            System.out.printf("\t%s: %s\n", c.getCommenter().getUsername(), c.getText());
        }
    }


    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public User[] getLikers() {
        return likers;
    }

    public void setLikers(User[] likers) {
        this.likers = likers;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public int getLikersCount() {
        return likersCount;
    }

    public void setLikersCount(int likersCount) {
        this.likersCount = likersCount;
    }


    public int getCommentCount() {
        return this.commentCount;
    }


}
