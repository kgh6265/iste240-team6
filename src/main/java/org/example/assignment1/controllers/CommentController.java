package org.example.assignment1.controllers;

import org.example.assignment1.model.Comment;
import org.example.assignment1.services.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    private MainService mainService;

    public CommentController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/comments")
    public String getComments(Model model) {
        model.addAttribute("commentList", mainService.findAllComments());
        return "comments";
    }

    @GetMapping("/comments/add")
    public String getAddCommentForm() {
        return "comments-add";
    }

    @PostMapping("/comments/add")
    public String addComment(Comment comment, Model model) {
        mainService.addComment(comment);
        return "redirect:/add/success/Comment";
    }
}

