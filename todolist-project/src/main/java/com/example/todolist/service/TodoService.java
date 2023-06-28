package com.example.todolist.service;

import com.example.todolist.model.Todo;

import java.util.List;

public interface TodoService {

    Todo create(Todo todo);

    List<Todo> getAll();

    Todo getById(Long id);

    Todo updateById(Long id, Todo todo);

    void deleteById(Long id);

    Todo completeById(Long id);
}