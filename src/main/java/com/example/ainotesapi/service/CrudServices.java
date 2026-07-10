package com.example.ainotesapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.ainotesapi.exception.NoteNotFoundException;
import com.example.ainotesapi.model.Note;
import com.example.ainotesapi.repository.NoteRepository;
import jakarta.transaction.Transactional;

@Service
public class CrudServices {

    private final GeminiService geminiService;
    private final NoteRepository noteRepository;

    public CrudServices(GeminiService geminiService, NoteRepository noteRepository) {
        this.geminiService = geminiService;
        this.noteRepository = noteRepository;
    }

    public List<Note> returnAllNotes() {
        return noteRepository.findAll();
