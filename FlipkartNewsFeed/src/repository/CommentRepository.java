package repository;

import model.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommentRepository {
    private static CommentRepository commentRepository;
    private HashMap<String, Comment> comments;
    private HashMap<String, List<Comment>> commentsByPostId;

    public CommentRepository() {
        this.comments = new HashMap<>();
        this.commentsByPostId = new HashMap<>();
    }

    public static CommentRepository getInstance() {
        if (commentRepository == null)
            commentRepository = new CommentRepository();
        return commentRepository;
    }

    public void addComment(Comment comment) {
        List<Comment> commentsList = new ArrayList<>();
        comments.put(comment.getId(), comment);
        if (commentsByPostId.containsKey(comment.getPostId()))
            commentsList = commentsByPostId.get(comment.getPostId());

        commentsList.add(comment);
        commentsByPostId.put(comment.getPostId(), commentsList);

    }

    public List<Comment> getCommentByPostId(String postId) {
        return commentsByPostId.get(postId);
    }
}
