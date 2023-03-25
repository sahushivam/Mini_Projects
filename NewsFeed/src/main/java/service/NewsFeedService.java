package service;

import models.Post;

import java.util.List;

public interface NewsFeedService {

    List<Post> getPost(String name);

    public List<Post> getNewsFeed(String name);
}
