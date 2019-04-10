package com.work.request.controller;

import com.work.request.exception.CommentNotFoundException;
import com.work.request.exception.RequestNotFoundException;
import com.work.request.model.Comment;
import com.work.request.repository.CommentRepository;
import com.work.request.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("/requests/{requestId}/comments")
    public List<Comment> getCommentsByQuestionId(@PathVariable Long requestId) {
        return commentRepository.findByRequestId(requestId);
    }
    @GetMapping("/requests/{requestId}/comments/{commentId}")
    public Comment getCommentByQuestionId(@PathVariable Long requestId, @PathVariable Long commentId) {
        requestRepository.findById(requestId)
                .orElseThrow(() -> new RequestNotFoundException(requestId));
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
    }

    @PostMapping("/requests/{requestId}/comments")
    public Comment addComment(@PathVariable Long requestId,
                              @RequestBody  String comment) {
        return requestRepository.findById(requestId)
                .map(request -> { Comment com = new Comment(requestId, comment, request);
                    return commentRepository.save(com);
                }).orElseThrow(() -> new RequestNotFoundException(requestId));
    }

    @PutMapping("/requests/{requestId}/comments/{commentId}")
    public Comment updateComment(@PathVariable Long requestId,
                                 @PathVariable Long commentId,
                                 @RequestBody  String commentUpd) {
        if(!requestRepository.existsById(requestId)) {
            throw new RequestNotFoundException(requestId);
        }

        return commentRepository.findById(commentId)
                .map(comment -> {
                    comment.setText(commentUpd);
                    return commentRepository.save(comment);
                }).orElseThrow(() -> new CommentNotFoundException(commentId));
    }

    @DeleteMapping("/requests/{requestId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long requestId,
                                           @PathVariable Long commentId) {
        if(!requestRepository.existsById(requestId)) {
            throw new RequestNotFoundException(requestId);
        }

        return commentRepository.findById(commentId)
                .map(comment -> {
                    commentRepository.delete(comment);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new CommentNotFoundException(commentId));

    }
}
