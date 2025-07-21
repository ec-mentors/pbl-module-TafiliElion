package pbl_module.conlang_creator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pbl_module.conlang_creator.dto.request.WordRequestDTO;
import pbl_module.conlang_creator.model.Word;
import pbl_module.conlang_creator.service.MorphemeService;
import pbl_module.conlang_creator.service.WordService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/words")
public class WordWebController {

    private final WordService wordService;
    private final MorphemeService morphemeService;

    @GetMapping
    public String listWords(@RequestParam("projectId") Long projectId, Model model) {
        List<Word> words = wordService.getWordsByProjectId(projectId);
        model.addAttribute("words", words);
        model.addAttribute("projectId", projectId);
        return "word_list";
    }

    @GetMapping("/add")
    public String showAddForm(@RequestParam("projectId") Long projectId, Model model) {
        WordRequestDTO wordDto = new WordRequestDTO();
        wordDto.setLanguageProjectId(projectId);

        model.addAttribute("wordDto", wordDto);
        model.addAttribute("morphemes", morphemeService.findByProjectId(projectId));
        return "word_add";
    }

    @PostMapping("/add")
    public String handleAddWord(@ModelAttribute("wordDto") WordRequestDTO dto, RedirectAttributes redirectAttributes) {
        wordService.createWord(dto);
        redirectAttributes.addAttribute("projectId", dto.getLanguageProjectId());
        return "redirect:/words";
    }

    @PostMapping("/delete/{id}")
    public String deleteWord(@PathVariable Long id, @RequestParam("projectId") Long projectId, RedirectAttributes redirectAttributes) {
        wordService.deleteById(id);
        redirectAttributes.addAttribute("projectId", projectId);
        return "redirect:/words";
    }
}
