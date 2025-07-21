package pbl_module.conlang_creator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pbl_module.conlang_creator.dto.request.LanguageProjectRequestDTO;
import pbl_module.conlang_creator.model.LanguageProject;
import pbl_module.conlang_creator.service.LanguageProjectService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class LanguageProjectWebController {

    private final LanguageProjectService projectService;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("projectDto", new LanguageProjectRequestDTO());
        return "project_add";
    }

    @PostMapping("/add")
    public String handleAddProject(@ModelAttribute("projectDto") LanguageProjectRequestDTO dto,
                                   RedirectAttributes redirectAttributes) {
        LanguageProject project = projectService.create(dto);
        redirectAttributes.addAttribute("projectId", project.getId());
        return "redirect:/words";
    }

    @GetMapping
    public String listProjects(Model model) {
        List<LanguageProject> projects = projectService.getAll();
        model.addAttribute("projects", projects);
        return "project_list";
    }


    @GetMapping("/")
    public String redirectToProjects() {
        return "redirect:/projects";
    }

}
