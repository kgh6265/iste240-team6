package org.example.assignment1.repositories;

import org.example.assignment1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByStatus(String status);

    List<Event> findByCategory(String category);

    @Query("SELECT e FROM Event e WHERE e.title LIKE %:keyword%")
    List<Event> searchByTitle(@Param("keyword") String keyword);

    @Modifying
    @Query("UPDATE Event e SET e.status = :status WHERE e.id = :id")
    int updateStatusById(@Param("id") Long id, @Param("status") String status);

}