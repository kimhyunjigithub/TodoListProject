package com.example.todolist.service;

import com.example.todolist.model.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TodoServiceTest {

    private TodoService todoService;

    @BeforeEach
    public void setup() {
        todoService = new TodoServiceImpl();
    }

    @Test
    public void testCreateTodo() {
        Todo todo = new Todo();
        todo.setTitle("Buy groceries");

        Todo createdTodo = todoService.create(todo);

        assertNotNull(createdTodo.getId());
        assertEquals("Buy groceries", createdTodo.getTitle());
        assertEquals(false, createdTodo.isCompleted());
    }

    // Add more test methods
}