package pbl_module.conlang_creator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pbl_module.conlang_creator.dto.request.MorphemeRequestDTO;
import pbl_module.conlang_creator.model.LanguageProject;
import pbl_module.conlang_creator.model.Morpheme;
import pbl_module.conlang_creator.model.Phoneme;
import pbl_module.conlang_creator.repositories.LanguageProjectRepository;
import pbl_module.conlang_creator.repositories.MorphemeRepository;
import pbl_module.conlang_creator.repositories.PhonemeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MorphemeService {
    private final MorphemeRepository morphemeRepository;
    private final PhonemeRepository phonemeRepository;
    private final LanguageProjectRepository languageProjectRepository;


    public List<Morpheme> findByProjectId(Long id) {
        return morphemeRepository.findByLanguageProjectId(id);
    }

    public Morpheme createMorpheme(MorphemeRequestDTO dto) {
        LanguageProject project = languageProjectRepository.findById(dto.getLanguageProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found."));

        List<Phoneme> phonemes = phonemeRepository.findAllById(dto.getPhonemeIds());

        Morpheme morpheme = new Morpheme();
        morpheme.setForm(dto.getForm());
        morpheme.setMeaning(dto.getMeaning());
        morpheme.setType(dto.getType());
        morpheme.setLanguageProject(project);
        morpheme.setPhonemesInMorpheme(phonemes);

        return morphemeRepository.save(morpheme);
    }

    public void deleteMorpheme(Long id) {
        morphemeRepository.deleteById(id);
    }



}
