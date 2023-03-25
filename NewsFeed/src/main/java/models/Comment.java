package models;

import java.util.UUID;

public class Comment {

    private UUID commentId;
    private String commentText;
    private String userName;
    private UUID postId;

    public Comment(String userName, String commentText) {
        this.userName = userName;
        this.commentId = UUID.randomUUID();
        this.commentText = commentText;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
