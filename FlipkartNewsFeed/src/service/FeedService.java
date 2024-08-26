package service;

import model.Post;
import repository.PostRespository;
import repository.UserRespository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FeedService {

    private final PostRespository postRespository;
    private final UserRespository userRespository;

    public FeedService(PostRespository postRespository, UserRespository userRespository) {
        this.postRespository = postRespository;
        this.userRespository = userRespository;
    }


    public void getFeed(String name) {
        if (!userRespository.checkUserExist(name) && !userRespository.isUserLoggedIn(name)) {
            System.out.println("User doesn't exist or not logged in");
            return;
        }
        List<Post> posts = postRespository.getAllPosts();
        List<String> followedUsers = userRespository.getFollowedUser(name);
        List<Post> followedUsersPost = posts.stream().filter(post -> followedUsers.contains(post.getUserName())).collect(Collectors.toUnmodifiableList());
        List<Post> othersUsersPost = posts.stream().filter(post -> !(followedUsers.contains(post.getUserName())))
                .filter(post -> !(post.getUserName().equals(name))).collect(Collectors.toUnmodifiableList());

//        showFeed(ownPost);
        showFeed(followedUsersPost);
        showFeed(othersUsersPost);
    }

    private void showFeed(List<Post> posts) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:MM:SS");

        posts.stream()
                .sorted(Comparator
                        .comparing(Post::getPostedAt).reversed() // Newest first
                        .thenComparing(post -> (post.getUpvotes() - post.getDownvotes())) // Largest voteDiff first
                        .thenComparing(post -> post.getCommentList().size())
                ).forEach(post -> {
                    System.out.println("Post id-> " + post.getId());
                    System.out.println("(Upvote -> " + post.getUpvotes() + ", Downvote -> " + post.getDownvotes() + ")");
                    System.out.println("Posted By-> " + post.getUserName());
                    System.out.println("Posted At->" + post.getPostedAt().format(formatter));
                    System.out.println("Posted At in human readable format->" + getTimeDiff(post.getPostedAt()));
                    System.out.println(" ");
                });

    }

    private String getTimeDiff(LocalDateTime postedAt) {
        long timeDiff = Duration.between(postedAt, LocalDateTime.now()).getSeconds();
        String time = "";
        if (timeDiff < 60) {
            time = timeDiff + "s ago";
        } else if (timeDiff < 3600) {
            time = timeDiff / 60 + "m ago";
        } else if (timeDiff < 86400) {
            time = timeDiff / 3600 + "h ago";
        } else if (timeDiff < 604800) {
            time = timeDiff / 86400 + "d ago";
        } else {
            time = timeDiff / 604800 + "w ago";
        }
        return time;
    }
}
