package pbl_module.conlang_creator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        LanguageProject project = projectService.findById(id);
        LanguageProjectRequestDTO dto = new LanguageProjectRequestDTO(project.getName(), project.getDescription());
        model.addAttribute("projectId", id);
        model.addAttribute("projectDto", dto);
        return "project_edit";
    }

    @PostMapping("/edit/{id}")
    public String handleEditProject(@PathVariable Long id,
                                    @ModelAttribute("projectDto") LanguageProjectRequestDTO dto) {
        projectService.update(id, dto);
        return "redirect:/projects";
    }

    @PostMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteById(id);
        return "redirect:/projects";
    }

    @GetMapping("/{id}/dashboard")
    public String showProjectDashboard(@PathVariable Long id, Model model) {
        LanguageProject project = projectService.findById(id);
        model.addAttribute("project", project);
        return "project_dashboard";
    }


}
