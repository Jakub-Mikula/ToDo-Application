package com.todo.todoapp.Repositories;

import com.todo.todoapp.DTOs.PostToDoDTO;
import com.todo.todoapp.Models.ToDo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ToDoRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<ToDo> getAllTodos(){
        Query query = entityManager.createNativeQuery("SELECT * FROM todos");
        System.out.println(query.getResultList().get(0));
        return query.getResultList();
    }

    public List<ToDo> getAllTodosOfType(String type){
        Query query = entityManager.createNativeQuery("SELECT * FROM todos WHERE type = :type");
        query.setParameter("type", type);
        return query.getResultList();
    }

    public ToDo findToDoById (long id){
        return entityManager.find(ToDo.class, id);
    }

    @Transactional
    public ToDo addNewToDo(PostToDoDTO postToDoDTO){
        ToDo toDo = new ToDo();
        toDo.setName(postToDoDTO.getName());
        toDo.setContent(postToDoDTO.getContent());
        toDo.setType(postToDoDTO.getType());
        return entityManager.merge(toDo);
    }

    @Transactional
    public String deleteToDo(long id){
        entityManager.remove(findToDoById(id));
        return "This todo was deleted";
    }
}
