package com.todo.todoapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping(value = "")
    public String main(){
        return "index";
    }

    @GetMapping(value = "/addToDo")
    public String addTodo(){
        return "addTodo";
    }
}
