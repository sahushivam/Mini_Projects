package service.impl;

import models.Post;
import models.User;
import service.NewsFeedService;
import service.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class NewsFeedServiceImpl implements NewsFeedService {

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public List<Post> getPost(String name) {
        PostService postService = new PostServiceImpl();
        List<Post> collect = postService.getAllPost().stream()
                .filter(post -> post.getPostAuthorUserName().equalsIgnoreCase(name)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Post> getNewsFeed(String name) {
        User userByName = userService.getUserByName(name);
        //followers
        List<UUID> followings = userByName.getFollowingId();
        List<Post> getFollowingPosts = new ArrayList<>();
        //sorting based on parameters to
        return null;
    }


}
