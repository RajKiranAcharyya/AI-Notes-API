package com.example.ainotesapi.repository;
import com.example.ainotesapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    
}