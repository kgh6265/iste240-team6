package org.example.assignment1.services;
import org.example.assignment1.model.Student;
import org.example.assignment1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class StudentDataSeeder implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {


        if (studentRepository.count() == 0) {

            Student s1 = new Student();
            s1.setRitId("412002594");
            s1.setName("Khaleel Hassan");
            s1.setEmail("kgh6265@rit.edu");
            s1.setActive(true);
            studentRepository.save(s1);

            Student s2 = new Student();
            s2.setRitId("761005899");
            s2.setName("Aditya Avinash");
            s2.setEmail("aa1234@rit.edu");
            s2.setActive(true);
            studentRepository.save(s2);

            Student s3 = new Student();
            s3.setRitId("400003132");
            s3.setName("Harsh Bhatia");
            s3.setEmail("hb5678@rit.edu");
            s3.setActive(true);
            studentRepository.save(s3);

            Student s4 = new Student();
            s4.setRitId("123456789");
            s4.setName("Sara Ali");
            s4.setEmail("sa1234@rit.edu");
            s4.setActive(true);
            studentRepository.save(s4);

            Student s5 = new Student();
            s5.setRitId("987654321");
            s5.setName("Omar Nasser");
            s5.setEmail("on9876@rit.edu");
            s5.setActive(false);
            studentRepository.save(s5);

            System.out.println("Student seed data inserted.");
        } else {
            System.out.println("Students table already has data, skipping seed.");
        }
    }
}