package repository;

import model.Comment;
import model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostRespository {

    private static PostRespository postRespository;
    private HashMap<String, Post> posts;
    private HashMap<String, List<Post>> postsByUser;

    public PostRespository() {
        this.posts = new HashMap<>();
        this.postsByUser = new HashMap<>();
    }

    public static PostRespository getInstance() {
        if (postRespository == null)
            postRespository = new PostRespository();
        return postRespository;
    }

    public void createPost(Post post) {
        posts.put(post.getId(), post);
        List<Post> postsByUsers = new ArrayList<>();
        if (postsByUser.containsKey(post.getUserName())) {
            postsByUsers = postsByUser.get(post.getUserName());
            postsByUsers.add(post);
        } else {
            postsByUsers.add(post);
        }
        postsByUser.put(post.getUserName(), postsByUsers);
    }

    public boolean isPostExist(String postId) {
        if (posts.containsKey(postId))
            return true;
        return false;
    }

    public Post upvotePost(String postId) {
        Post post = posts.get(postId);
        post.upvote();
        posts.put(postId, post);
        return post;
    }

    public Post downVote(String postId) {
        Post post = posts.get(postId);
        post.downvote();
        posts.put(postId, post);
        return post;
    }

    public List<Post> getAllPosts() {
        return posts.values().stream().toList();
    }

    public void addComment(Comment comment) {
        Post post = posts.get(comment.getPostId());
        post.getCommentList().add(comment);
    }
}
