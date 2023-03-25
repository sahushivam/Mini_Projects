package service.impl;

import exception.PostNotFoundException;
import models.Comment;
import models.Post;
import service.InteractionService;
import service.PostService;

import java.util.List;
import java.util.UUID;

public class InteractionServiceImpl implements InteractionService {

    PostService postService = new PostServiceImpl();
    @Override
    public void upvote(String userName, UUID postId) {
        if(postService.checkIfPostExists(postId)) {
            Post postById = postService.getPostById(postId);
            postById.setUpvote(postById.getUpvote()+1);
        }
        throw new PostNotFoundException();
    }

    @Override
    public void downvote(String userName, UUID postId) {
        if(postService.checkIfPostExists(postId)) {
            Post postById = postService.getPostById(postId);
            postById.setDownvote(postById.getDownvote()+1);
        }
    }

    @Override
    public void comment(String userName, UUID postId, String commentText) {
        if(postService.checkIfPostExists(postId)) {
            Post postById = postService.getPostById(postId);
            List<Comment> commentList = postById.getCommentList();
            commentList.add(new Comment(userName, commentText));
            postById.setComment(commentList);
        }
    }
}
