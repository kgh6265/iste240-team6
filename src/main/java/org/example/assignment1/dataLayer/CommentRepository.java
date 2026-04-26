package org.example.assignment1.dataLayer;

import org.example.assignment1.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(Long id);

    List<Comment> findAll();

    @Query("SELECT c FROM Comment c WHERE c.student.id = :studentId")
    List<Comment> findByStudentId(@Param("studentId") Integer studentId);

    @Modifying
    @Query("UPDATE Comment c SET c.content = :content WHERE c.id = :id")
    int updateContentById(@Param("id") Long id, @Param("content") String content);

    @Query("SELECT c FROM Comment c WHERE c.event.id = :eventId")
    List<Comment> findByEventId(@Param("eventId") Long eventId);

    @Query("SELECT c FROM Comment c WHERE c.student.id = :studentId")
    List<Comment> findByStudentId(@Param("studentId") Long studentId);

    void deleteById(Long id);
}