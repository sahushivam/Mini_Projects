package repository;

import models.Post;

import java.util.List;
import java.util.UUID;

public interface PostRepo {

    UUID post(String userName, String content);

    List<Post> getAllPost();

    boolean checkIfPostExists(UUID postId);

    Post getPostById(UUID postId);
}
