package models;

import java.util.List;
import java.util.UUID;

public class Post {

    private UUID postId;
    private String postAuthorUserName;
    private String postText;
    private List<Comment> comment;
    private Integer upvote;
    private Integer downvote;

    public Integer getUpvote() {
        return upvote;
    }

    public void setUpvote(Integer upvote) {
        this.upvote = upvote;
    }

    public Integer getDownvote() {
        return downvote;
    }

    public void setDownvote(Integer downvote) {
        this.downvote = downvote;
    }



    public String getPostAuthorUserName() {
        return postAuthorUserName;
    }

    public void setPostAuthorUserName(String postAuthorUserName) {
        this.postAuthorUserName = postAuthorUserName;
    }

    public Post(String postAuthorUserName, String postText) {
        setPostId(UUID.randomUUID());
        this.postAuthorUserName = postAuthorUserName;
        this.postText = postText;
        this.upvote = 0;
        this.downvote = 0;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public List<Comment> getCommentList() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }




}
