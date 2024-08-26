package model;

import java.time.LocalDateTime;

public class Comment {

    private String id;
    private String postId;
    private String commentContent;
    private String repliedBy;
    private LocalDateTime commentedAt;

    public Comment(String id, String postId, String commentContent, String repliedBy) {
        this.id = id;
        this.postId = postId;
        this.commentContent = commentContent;
        this.repliedBy = repliedBy;
        this.commentedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getRepliedBy() {
        return repliedBy;
    }

    public void setRepliedBy(String repliedBy) {
        this.repliedBy = repliedBy;
    }

    public LocalDateTime getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(LocalDateTime commentedAt) {
        this.commentedAt = commentedAt;
    }
}
