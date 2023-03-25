package service.impl;

import exception.PostNotFoundException;
import models.Post;
import repository.UserRepository;
import repository.impl.PostRepoImpl;
import repository.impl.UserRepositoryImpl;
import service.PostService;
import service.UserService;

import java.util.List;
import java.util.UUID;

public class PostServiceImpl implements PostService {

    PostRepoImpl postRepo = new PostRepoImpl();
    UserService userService = new UserServiceImpl();

    @Override
    public UUID makePost(String user, String postContent) {
        userService.checkIfUserExists(user);
        return postRepo.post(user, postContent);
    }

    @Override
    public List<Post> getAllPost() {
         return postRepo.getAllPost();
    }

    @Override
    public boolean checkIfPostExists(UUID postId) {
        return postRepo.checkIfPostExists(postId);
    }

    @Override
    public Post getPostById(UUID postId) {
        if(checkIfPostExists(postId)) {
            postRepo.getPostById(postId);
        }
        throw new PostNotFoundException();
    }


}
