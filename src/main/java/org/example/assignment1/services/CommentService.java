package org.example.assignment1.services;

import jakarta.transaction.Transactional;
import org.example.assignment1.dataLayer.CommentRepository;
import org.example.assignment1.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> getCommentsByStudent(Integer studentId) {
        return commentRepository.findByStudentid(studentId);
    }

    public Comment updateComment(Long id, Comment details) {
        Comment existing = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        existing.setContent(details.getContent());
        existing.setEventid(details.getEventid());
        existing.setStudentid(details.getStudentid());
        return commentRepository.save(existing);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}