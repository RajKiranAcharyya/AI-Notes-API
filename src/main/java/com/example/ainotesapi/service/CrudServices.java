package com.example.ainotesapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.ainotesapi.exception.NoteNotFoundException;
import com.example.ainotesapi.model.Note;
import com.example.ainotesapi.repository.NoteRepository;
import jakarta.transaction.Transactional;

@Service
public class CrudServices {
