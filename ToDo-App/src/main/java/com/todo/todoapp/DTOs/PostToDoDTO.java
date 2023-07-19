package com.todo.todoapp.DTOs;

import lombok.*;

@Data
@Getter
@Setter
public class PostToDoDTO {
    private String name;
    private String content;
    private String type;
}
