import repository.CommentRepository;
import repository.PostRespository;
import repository.UserRespository;
import service.CommentService;
import service.FeedService;
import service.PostService;
import service.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        UserRespository userRespository = UserRespository.getInstance();
        PostRespository postRespository = PostRespository.getInstance();
        CommentRepository commentRepository = CommentRepository.getInstance();

        UserService userService = new UserService(userRespository);
        PostService postService = new PostService(postRespository, userRespository);
        CommentService commentService = new CommentService(commentRepository, postRespository, userRespository);
        FeedService feedService = new FeedService(postRespository, userRespository);


        userService.registerUser("Simran");
        userService.registerUser("Prachi");
        userService.registerUser("Mansi");

        userService.login("Simran");

        userService.follow("Simran", "Prachi");
//        userService.follow("Simran", "Mansi");

        userService.logout("Simran");

        String postId1 = postService.createPost("Simran", "This is my first post");
        String postId2 = postService.createPost("Simran", "This is my second post");
        String postId3 = postService.createPost("Prachi", "This is Prachi's first post");
        String postId4 = postService.createPost("Mansi", "This is Mansi's first post");
        String postId5 = postService.createPost("Prachi", "This is Prachi's second post");

        postService.upvotePost("Prachi", postId1);
        postService.upvotePost("Simran", postId3);
        postService.upvotePost("Simran", postId5);

        commentService.addComment("Prachi", postId1, "Perfect");
        commentService.addComment("Simran", postId3, "Disliked");
        commentService.getCommentByPostId(postId1);

        feedService.getFeed("Simran");
    }
}