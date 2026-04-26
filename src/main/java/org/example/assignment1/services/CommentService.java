// Stydent Name: Khaleel Hassan | Student ID: 412002594
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
        return commentRepository.findByStudentId(studentId);
    }

    public List<Comment> getCommentsByEvent(Long eventId) {
        return commentRepository.findByEventId(eventId);
    }

    public Comment updateComment(Long id, Comment details) {
        Comment existing = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        existing.setContent(details.getContent());
        existing.setEvent(details.getEvent());
        existing.setStudent(details.getStudent());

        return commentRepository.save(existing);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}