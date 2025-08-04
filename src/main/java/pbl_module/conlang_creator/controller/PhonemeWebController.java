package pbl_module.conlang_creator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pbl_module.conlang_creator.dto.request.PhonemeRequestDTO;
import pbl_module.conlang_creator.model.Phoneme;
import pbl_module.conlang_creator.service.PhonemeService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/phonemes")
public class PhonemeWebController {

    private final PhonemeService phonemeService;

    @GetMapping
    public String listPhonemes(@RequestParam("projectId") Long projectId, Model model) {
        List<Phoneme> phonemes = phonemeService.findByProjectId(projectId);
        model.addAttribute("phonemes", phonemes);
        model.addAttribute("projectId", projectId);
        return "phoneme_list";
    }

    @GetMapping("/add")
    public String showAddForm(@RequestParam("projectId") Long projectId, Model model) {
        PhonemeRequestDTO dto = new PhonemeRequestDTO();
        dto.setLanguageProjectID(projectId);
        model.addAttribute("phonemeDto", dto);
        return "phoneme_add";
    }

    @PostMapping("/add")
    public String handleAdd(@ModelAttribute("phonemeDto") PhonemeRequestDTO dto, RedirectAttributes redirectAttributes) {
        phonemeService.createPhoneme(dto);
        redirectAttributes.addAttribute("projectId", dto.getLanguageProjectID());
        return "redirect:/phonemes";
    }

    @PostMapping("/delete/{id}")
    public String deletePhoneme(@PathVariable Long id, @RequestParam("projectId") Long projectId, RedirectAttributes redirectAttributes) {
        phonemeService.deleteById(id);
        redirectAttributes.addAttribute("projectId", projectId);
        return "redirect:/phonemes";
    }
}
