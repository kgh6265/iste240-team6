package org.example.assignment1.repository;
import org.example.assignment1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;
public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findByName(String name);

    Optional<Student> findByEmail(String email);

    boolean existsByEmail(String email);


    @Query("SELECT s FROM Student s WHERE s.name LIKE %:name%")
    List<Student> searchByName(@Param("name") String name);


    @Modifying
    @Query("UPDATE Student s SET s.active = :active WHERE s.id = :id")
    int updateActiveById(@Param("id") Long id, @Param("active") boolean active);


}