package repository.impl;

import models.Post;
import repository.PostRepo;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PostRepoImpl implements PostRepo {

    private static HashMap<UUID, Post> postRepo =  new HashMap<>();;
    private static PostRepo postRepoObject;

    @Override
    public UUID post(String userName, String content) {
        Post post = new Post(userName, content);
        postRepo.put(post.getPostId(), post);
        return post.getPostId();
    }

    @Override
    public List<Post> getAllPost() {
        return postRepo.values().stream().toList();
    }


    @Override
    public boolean checkIfPostExists(UUID postId) {
        return postRepo.containsKey(postId);
    }

    @Override
    public Post getPostById(UUID postId) {
        return getPostById(postId);
    }
}
