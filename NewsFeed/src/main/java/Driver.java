import exception.UserNotFoundException;
import models.Post;
import service.NewsFeedService;
import service.PostService;
import service.UserService;
import service.impl.NewsFeedServiceImpl;
import service.impl.PostServiceImpl;
import service.impl.UserServiceImpl;

import java.util.List;

public class Driver {


    public static void main(String args[]) {
        UserService  userService;
        userService = new UserServiceImpl();
        System.out.println(userService.signup("Tushar"));
        System.out.println(userService.login("Tushar"));
        //User is not available
        try {
            System.out.println(userService.login("Tushar 1"));
        }   catch (UserNotFoundException ex) {
            System.out.println("User is not available");
        }

        PostService postService = new PostServiceImpl();
        System.out.println(postService.makePost("Tushar", "This is new post on 23/03"));

        System.out.println(postService.makePost("Tushar", "This is new post on 23/04"));


        try {
            System.out.println(postService.makePost("Shivam", "This is new post on 23/04"));
        }   catch (UserNotFoundException ex) {
            System.out.println("Shivam is not registered to make a post");
        }

        userService.follow("Tushar", "Tushar");

        try {
            userService.follow("Shivam", "Tushar");
        }   catch (UserNotFoundException ex) {
            System.out.println("Shivam is not registered");
        }

        List<Post> allPost = postService.getAllPost();
        allPost.forEach(post -> System.out.println(post.getPostText()));

        NewsFeedService newsFeedService = new NewsFeedServiceImpl();
        List<Post> tusharPost = newsFeedService.getPost("Tushar");
        tusharPost.forEach(post -> System.out.println(post.getPostText()));

        try {
            List<Post> shivamPost = newsFeedService.getPost("Shivam");
            shivamPost.forEach(post -> System.out.println(post.getPostText()));
        }   catch (UserNotFoundException ex) {
            System.out.println("Shivam is not registered");
        }

    }
}
