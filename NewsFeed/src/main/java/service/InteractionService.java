package service;

import models.Comment;

import java.util.UUID;

public interface InteractionService {

    void upvote(String userName, UUID postId);
    void downvote(String userName, UUID postId);
    void comment(String userName, UUID postId, String commentText);
}
