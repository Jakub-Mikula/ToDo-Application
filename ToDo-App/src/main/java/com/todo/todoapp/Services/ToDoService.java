package com.todo.todoapp.Services;

import com.todo.todoapp.DTOs.GetToDoDTO;
import com.todo.todoapp.DTOs.PostToDoDTO;
import com.todo.todoapp.Models.ToDo;
import com.todo.todoapp.Repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository toDoRepository;


    public List<ToDo> getAllTodos(){
        return toDoRepository.getAllTodos();
    }

    public List<ToDo> getAllTodosOfType(String type) throws Exception {
            if (!(type.equals("shopping") || type.equals("house") || type.equals("friends") || type.equals("job"))){
                throw new Exception("There is no type like this");
            }
            List<ToDo> toDos = toDoRepository.getAllTodosOfType(type);
            if (toDos.isEmpty()){
                throw new Exception("There are no tasks of this type");
            } else {
                return toDos;
            }
    }

    public ToDo addNewToDo(PostToDoDTO postToDoDTO) throws Exception {
        String type = postToDoDTO.getType();
        System.out.println(type);
        if (!(type.equals("shopping") || type.equals("house") || type.equals("friends") || type.equals("job"))){
            throw new Exception("There is no type like this");
        } else if (postToDoDTO.getName().isEmpty()){
            throw new Exception("Please fill in the name of the todo");
        } else if (postToDoDTO.getContent().isEmpty()) {
            throw new Exception("Please fill some content to this todo");
        } else {
            return toDoRepository.addNewToDo(postToDoDTO);
        }
    }

    public String deleteToDo(long id) throws Exception {
        if (toDoRepository.findToDoById(id) == null){
            throw new Exception("No todo with this id exists");
        }
        return toDoRepository.deleteToDo(id);
    }
}
