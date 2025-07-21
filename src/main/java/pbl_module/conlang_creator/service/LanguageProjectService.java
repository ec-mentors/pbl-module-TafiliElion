package pbl_module.conlang_creator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pbl_module.conlang_creator.dto.request.LanguageProjectRequestDTO;
import pbl_module.conlang_creator.model.LanguageProject;
import pbl_module.conlang_creator.repositories.LanguageProjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageProjectService {

    private final LanguageProjectRepository languageProjectRepository;

    public LanguageProject create(LanguageProjectRequestDTO dto) {
        LanguageProject project = new LanguageProject();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        return languageProjectRepository.save(project);
    }

    public List<LanguageProject> getAll() {
        return languageProjectRepository.findAll();
    }

    public LanguageProject findById(Long id) {
        return languageProjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found."));
    }

    public void update(Long id, LanguageProjectRequestDTO dto) {
        LanguageProject project = findById(id);
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        languageProjectRepository.save(project);
    }

    public void deleteById(Long id) {
        languageProjectRepository.deleteById(id);
    }
}
