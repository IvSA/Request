package com.work.request.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CommentNotFoundException extends RuntimeException {

    private Long commentId;

    public CommentNotFoundException(Long commentId) {
        super(String.format("Comment no.%s not found.", commentId));
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}

