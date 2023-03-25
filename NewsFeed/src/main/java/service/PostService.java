package service;

import models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    UUID makePost(String user, String postContent);

    List<Post> getAllPost();

    boolean checkIfPostExists(UUID postId);

    Post getPostById(UUID postId);
}
