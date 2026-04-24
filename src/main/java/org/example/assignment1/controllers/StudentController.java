package org.example.assignment1.controllers;

import org.example.assignment1.model.Student;
import org.example.assignment1.services.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private MainService mainService;

    public StudentController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("studentList", mainService.findAllStudents());
        return "students";
    }

    @GetMapping("/students/add")
    public String getAddStudentForm() {
        return "students-add";
    }

    @PostMapping("/students/add")
    public String addStudent(Student student, Model model) {
        mainService.addStudent(student);
        model.addAttribute("entityName", "Student");
        return "redirect:/add/success/Student";
    }
}
