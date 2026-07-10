package com.example.ainotesapi.controller;

import java.util.List;
import com.example.ainotesapi.model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.example.ainotesapi.service.CrudServices;
import com.example.ainotesapi.service.GeminiService;

@RestController
public class RequestController {

    @GetMapping("/")
    public String hello() {
        return "Welcome To AInOtEsAPI";
    }

    private final CrudServices crudServices;
    private final GeminiService geminiService;

    public RequestController(CrudServices crudServices, GeminiService geminiService) {
        this.crudServices = crudServices;
        this.geminiService = geminiService;
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> allNotes() {
        return new ResponseEntity<>(crudServices.returnAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/notes/getNote/{id}")
