package service;

import model.Post;
import repository.PostRespository;
import repository.UserRespository;

import java.util.UUID;

public class PostService {

    private final PostRespository postRespository;
    private final UserRespository userRespository;

    public PostService(PostRespository postRespository, UserRespository userRespository) {
        this.postRespository = postRespository;
        this.userRespository = userRespository;
    }

    public String createPost(String name, String content) {
        if (!userRespository.checkUserExist(name) && !userRespository.isUserLoggedIn(name)) {
            System.out.println("User doesn't exist or not logged in");
            return null;
        }
        String id = UUID.randomUUID().toString();
        Post post = new Post(id, content, name);
        postRespository.createPost(post);
        System.out.println(name + " created post with postId-> " + id);
        return id;
    }

    public void upvotePost(String name, String postId) {
        if (!userRespository.checkUserExist(name) && !userRespository.isUserLoggedIn(name)) {
            System.out.println("User doesn't exist or not logged in");
            return;
        }
        if (!postRespository.isPostExist(postId)) {
            System.out.println("Post doesn't exist");
            return;
        }
        Post post = postRespository.upvotePost(postId);
        System.out.println(name + " liked postId " + post.getId());
    }

    public void downVote(String name, String postId) {
        if (!userRespository.checkUserExist(name) && !userRespository.isUserLoggedIn(name)) {
            System.out.println("User doesn't exist or not logged in");
            return;
        }
        if (!postRespository.isPostExist(postId)) {
            System.out.println("Post doesn't exist");
            return;
        }
        Post post = postRespository.downVote(postId);
        System.out.println(name + " disliked postId " + post.getId());
    }
}
