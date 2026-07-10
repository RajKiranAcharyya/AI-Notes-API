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
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        // try {
        return new ResponseEntity<>(crudServices.findANote(id), HttpStatus.OK);
        // } catch (RuntimeException e) {
        // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
    }

    @GetMapping("/summarizer/noteSummarizer/{id}")
    public ResponseEntity<String> summarizeNote(@PathVariable Long id) {
        // try {
        return new ResponseEntity<>(crudServices.summarizeNoteById(id), HttpStatus.OK);
        // } catch (HttpServerErrorException e) {
        // return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        // }
    }

    @PostMapping("/notes/addNew")
    public ResponseEntity<Note> addNote(@Valid @RequestBody Note note) {
        return new ResponseEntity<>(crudServices.addANewNote(note), HttpStatus.CREATED);
    }

    @PostMapping("/summarizer/textSummarizer")
    public ResponseEntity<String> summarizeText(@RequestBody String text) {
        // try {
        return new ResponseEntity<>(geminiService.summarizeNote(text), HttpStatus.OK);
        // } catch (RuntimeException e) {
        // return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
    }

    @PutMapping("/notes/updateNote/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody Note note) {
        // try {
        return new ResponseEntity<>(crudServices.putUpdate(id, note), HttpStatus.OK);
        // } catch (RuntimeException e) {
        // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
    }

    @PatchMapping("/notes/updatePartOfNote/{id}")
    public ResponseEntity<Note> updatePartOfNoteRenameTitleAppendContent(@PathVariable Long id,
            @RequestBody Note note) {
        // try {
        return new ResponseEntity<>(crudServices.patchUpdateRenameTitleAppendContent(id, note), HttpStatus.OK);
        // } catch (RuntimeException e) {
        // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
    }

    @DeleteMapping("/notes/deleteNote/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        // try {
        return new ResponseEntity<>(crudServices.deleteANote(id), HttpStatus.OK);
        // } catch (RuntimeException e) {
        // return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
