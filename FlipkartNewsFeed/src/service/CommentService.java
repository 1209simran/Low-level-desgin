package service;

import model.Comment;
import repository.CommentRepository;
import repository.PostRespository;
import repository.UserRespository;

import java.util.List;
import java.util.UUID;

public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRespository postRespository;
    private final UserRespository userRespository;

    public CommentService(CommentRepository commentRepository, PostRespository postRespository, UserRespository userRespository) {
        this.commentRepository = commentRepository;
        this.postRespository = postRespository;
        this.userRespository = userRespository;
    }

    public void addComment(String name, String postId, String content) {
        if (!userRespository.checkUserExist(name) && !userRespository.isUserLoggedIn(name)) {
            System.out.println("User doesn't exist or not logged in");
            return;
        }
        if (!postRespository.isPostExist(postId)) {
            System.out.println("Post doesn't exist");
            return;
        }
        String commentId = UUID.randomUUID().toString();
        Comment comment = new Comment(commentId, postId, content, name);
        commentRepository.addComment(comment);
        postRespository.addComment(comment);
        System.out.println(name + " replied on postId " + postId);
    }

    public void getCommentByPostId(String postId) {
        if (!postRespository.isPostExist(postId)) {
            System.out.println("Post doesn't exist");
            return;
        }
        List<Comment> comments = commentRepository.getCommentByPostId(postId);
        if (comments != null)
            comments.forEach(comment -> System.out.println("Comment on post id " + comment.getPostId() + " -> " + comment.getCommentContent()
                    + ", by User -> " + comment.getRepliedBy()));
    }
}
