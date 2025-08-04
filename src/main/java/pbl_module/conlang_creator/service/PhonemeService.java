package pbl_module.conlang_creator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pbl_module.conlang_creator.dto.request.PhonemeRequestDTO;
import pbl_module.conlang_creator.model.LanguageProject;
import pbl_module.conlang_creator.model.Phoneme;
import pbl_module.conlang_creator.repositories.LanguageProjectRepository;
import pbl_module.conlang_creator.repositories.PhonemeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhonemeService {

    private final PhonemeRepository phonemeRepository;
    private final LanguageProjectRepository projectRepository;

    public Phoneme createPhoneme(PhonemeRequestDTO phonemeDTO) {
        LanguageProject project = projectRepository.findById(phonemeDTO.getLanguageProjectID())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Phoneme phoneme = new Phoneme();
        phoneme.setSymbol(phonemeDTO.getSymbol());
        phoneme.setCategory(phonemeDTO.getCategory());
        phoneme.setIpa(phonemeDTO.getIpa());
        phoneme.setLanguageProject(project);

        return phonemeRepository.save(phoneme);
    }

    public List<Phoneme> findByProjectId(Long id) {
        return phonemeRepository.findByLanguageProjectId(id);
    }

    public void deleteById(Long id) {
        phonemeRepository.deleteById(id);
    }
}
