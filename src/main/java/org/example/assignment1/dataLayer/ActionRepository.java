package org.example.assignment1.dataLayer;

import org.example.assignment1.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {
    Optional<Action> findById(Integer id);

    List<Action> findAll();

    @Query("SELECT a FROM Action a WHERE a.eventid = :eventId")
    List<Action> findByEventid(@Param("eventId") Integer eventId);

    @Modifying
    @Query("UPDATE Action a SET a.timestamp = :timestamp WHERE a.id = :id")
    int updateTimestampById(@Param("id") int id, @Param("timestamp") String timestamp);

    void deleteById(int id);
}