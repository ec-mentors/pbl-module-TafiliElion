package pbl_module.conlang_creator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbl_module.conlang_creator.model.Word;
import pbl_module.conlang_creator.dto.request.WordRequestDTO;
import pbl_module.conlang_creator.repositories.WordRepository;
import pbl_module.conlang_creator.service.WordService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/words")

public class WordController {

    private final WordService wordService;
    private final WordRepository wordRepository;

    @PostMapping
    public ResponseEntity<Word> createWord(@RequestBody WordRequestDTO dto) {
        Word saved = wordService.createWord(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Word>> getWordsByProjectId(@RequestParam Long projectId) {
        List<Word> words = wordService.getWordsByProjectId(projectId);
        return ResponseEntity.ok(words);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWord(@PathVariable Long id) {
        wordService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
