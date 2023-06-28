package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable("id") Long id) {
        return todoService.getById(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodoById(@PathVariable("id") Long id, @RequestBody Todo todo) {
        return todoService.updateById(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable("id") Long id) {
        todoService.deleteById(id);
    }

    @PatchMapping("/{id}/complete")
    public Todo completeTodoById(@PathVariable("id") Long id) {
        return todoService.completeById(id);
    }
}