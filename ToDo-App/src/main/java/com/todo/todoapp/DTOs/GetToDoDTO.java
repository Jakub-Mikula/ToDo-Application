package com.todo.todoapp.DTOs;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetToDoDTO {
    private long id;
    private String name;
    private String content;
}
