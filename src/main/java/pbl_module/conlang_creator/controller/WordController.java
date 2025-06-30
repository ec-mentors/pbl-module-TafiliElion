package pbl_module.conlang_creator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pbl_module.conlang_creator.model.Word;
import pbl_module.conlang_creator.model.WordRequestDTO;
import pbl_module.conlang_creator.service.WordService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/words")

public class WordController {

    private final WordService wordService;

    @PostMapping
    public ResponseEntity<Word> createWord(@RequestBody WordRequestDTO dto) {
        Word saved = wordService.createWord(dto);
        return ResponseEntity.ok(saved);
    }
}
