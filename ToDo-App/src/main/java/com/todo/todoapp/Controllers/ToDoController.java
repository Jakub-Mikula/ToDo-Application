package com.todo.todoapp.Controllers;

import com.todo.todoapp.DTOs.PostToDoDTO;
import com.todo.todoapp.Services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ToDoController {

    @Autowired
    ToDoService toDoService;
    @GetMapping(value = "api/todos")
    public ResponseEntity<?> getAllTodos(){
        return ResponseEntity.ok().body(toDoService.getAllTodos());
    }

    @GetMapping(value = "api/todo")
    public ResponseEntity<?>  getAllTodosByType(@RequestParam (value = "type", required = true)String type) throws Exception {
            try {
                return ResponseEntity.status(200).body(toDoService.getAllTodosOfType(type));
            }catch (Exception e){
                return ResponseEntity.status(400).body(e.getMessage());
            }
        }
    @PostMapping(value = "api/todo")
    public ResponseEntity<?> addNewToDo(@RequestBody PostToDoDTO postToDoDTO) throws Exception {
        try {
            return ResponseEntity.status(201).body(toDoService.addNewToDo(postToDoDTO));
        } catch (Exception e){
            HashMap errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.status(400).body(errorMap);
        }
    }
    @DeleteMapping(value = "api/todo/{id}")
    public ResponseEntity<?> deleteToDo(@PathVariable ("id") long id) throws Exception {
        try {
            return ResponseEntity.status(204).body(toDoService.deleteToDo(id));
        } catch (Exception e){
            HashMap errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.status(400).body(errorMap);
        }
    }
}
