package com.example.todolist.service;

import com.example.todolist.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final List<Todo> todos = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Todo create(Todo todo) {
        todo.setId(nextId);
        nextId++;
        todos.add(todo);
        return todo;
    }

    @Override
    public List<Todo> getAll() {
        return todos;
    }

    @Override
    public Todo getById(Long id) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public Todo updateById(Long id, Todo todo) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId().equals(id)) {
                todos.set(i, todo);
                return todo;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }

    @Override
    public Todo completeById(Long id) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                todo.setCompleted(true);
                return todo;
            }
        }
        return null;
    }
}