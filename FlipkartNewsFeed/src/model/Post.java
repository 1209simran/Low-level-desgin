package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private String id;
    private String content;
    private String userName;
    private LocalDateTime postedAt;
    private Long upvotes;
    private Long downvotes;
    private List<Comment> commentList;


    public Post(String id, String content, String userName) {
        this.id = id;
        this.content = content;
        this.userName = userName;
        this.postedAt = LocalDateTime.now();
        this.upvotes = 0L;
        this.downvotes = 0L;
        this.commentList = new ArrayList<>();
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public long getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(long upvotes) {
        this.upvotes = upvotes;
    }

    public long getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(long downvotes) {
        this.downvotes = downvotes;
    }


    public void upvote() {
        this.setUpvotes(this.upvotes + 1);
    }

    public void downvote() {
        this.setDownvotes(this.downvotes - 1);
    }
}
