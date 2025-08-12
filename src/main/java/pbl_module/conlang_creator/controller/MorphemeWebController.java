package pbl_module.conlang_creator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pbl_module.conlang_creator.dto.request.MorphemeRequestDTO;
import pbl_module.conlang_creator.model.Morpheme;
import pbl_module.conlang_creator.service.MorphemeService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/morphemes")
public class MorphemeWebController {

    private final MorphemeService morphemeService;

    @GetMapping
    public String listMorphemes(@RequestParam Long projectId, Model model) {
        List<Morpheme> morphemes = morphemeService.findByProjectId(projectId);
        model.addAttribute("morphemes", morphemes);
        model.addAttribute("projectId", projectId);
        return "morpheme_list";
    }

    @GetMapping("/add")
    public String showAddForm(@RequestParam Long projectId, Model model) {
        MorphemeRequestDTO dto = new MorphemeRequestDTO();
        dto.setLanguageProjectId(projectId);
        model.addAttribute("morphemeDto", dto);
        return "morpheme_add";

    }

    @PostMapping("/add")
    public String handleAddMorpheme(@ModelAttribute MorphemeRequestDTO dto, RedirectAttributes redirectAttributes) {
        morphemeService.createMorpheme(dto);
        redirectAttributes.addAttribute("projectId", dto.getLanguageProjectId());
        return "redirect:/morphemes";

    }

    @PostMapping("/delete/{id}")
    public String deleteMorpheme(@PathVariable Long id, @RequestParam Long projectId, RedirectAttributes redirectAttributes) {
        morphemeService.deleteMorpheme(id);
        redirectAttributes.addAttribute("projectId", projectId);
        return "redirect:/phonemes";
    }

}
