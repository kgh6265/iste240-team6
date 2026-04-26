package org.example.assignment1.services;

import java.util.ArrayList;
import java.util.List;
import org.example.assignment1.model.Comment;
import org.example.assignment1.model.Student;
import org.springframework.stereotype.Service;

@Service
public class MainService {

  List<Student> students = new ArrayList<Student>();
  List<Comment> comments = new ArrayList<Comment>();

  public MainService() {
    Student s1 = new Student();
    s1.setId("412002594");
    s1.setName("Khaleel Hassan");
    s1.setEmail("kgh6265@rit.edu");
    students.add(s1);

    Student s2 = new Student();
    s2.setId("761005899");
    s2.setName("Aditya Avinash");
    s2.setEmail("aa1234@rit.edu");
    students.add(s2);

    Student s3 = new Student();
    s3.setId("400003132");
    s3.setName("Harsh Bhatia");
    s3.setEmail("hb5678@rit.edu");
    students.add(s3);

    Comment c1 = new Comment();
    c1.setId("C1");
    c1.setEventid("E001");
    c1.setStudentid("412002594");
    c1.setContent("We should have more clubs and free food.");
    comments.add(c1);

    Comment c2 = new Comment();
    c2.setId("C2");
    c2.setEventid("E002");
    c2.setStudentid("761005899");
    c2.setContent("Looking forward to this!!!");
    comments.add(c2);
  }

  public List<Student> findAllStudents() {
    return this.students;
  }

  public void addStudent(Student student) {
    this.students.add(student);
  }

  public List<Comment> findAllComments() {
    return comments;
  }

  public void addComment(Comment comment) {
    this.comments.add(comment);
  }
}