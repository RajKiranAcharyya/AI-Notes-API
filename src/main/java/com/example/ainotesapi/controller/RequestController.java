package com.example.ainotesapi.controller;

import java.util.List;
import com.example.ainotesapi.model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.example.ainotesapi.service.CrudServices;
import com.example.ainotesapi.service.GeminiService;

