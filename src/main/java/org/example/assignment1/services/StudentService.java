package org.example.assignment1.services;
import jakarta.transaction.Transactional;
import org.example.assignment1.model.Student;
import org.example.assignment1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> searchByName(String name) {
        return studentRepository.searchByName(name);
    }

    public Student createStudent(Student student) {
        if (student.getEmail() == null || student.getEmail().isEmpty())
            throw new IllegalArgumentException("Email cannot be empty");
        if (studentRepository.existsByEmail(student.getEmail()))
            throw new RuntimeException("Email already exists: " + student.getEmail());
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updated) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setRitId(updated.getRitId());
        existing.setActive(updated.getActive());
        return studentRepository.save(existing);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}