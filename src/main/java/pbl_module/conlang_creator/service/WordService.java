package pbl_module.conlang_creator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pbl_module.conlang_creator.model.LanguageProject;
import pbl_module.conlang_creator.model.Morpheme;
import pbl_module.conlang_creator.model.Word;
import pbl_module.conlang_creator.dto.request.WordRequestDTO;
import pbl_module.conlang_creator.repositories.LanguageProjectRepository;
import pbl_module.conlang_creator.repositories.MorphemeRepository;
import pbl_module.conlang_creator.repositories.WordRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class WordService {
    private final WordRepository wordRepository;
    private final MorphemeRepository morphemeRepository;
    private final LanguageProjectRepository languageProjectRepository;

    public Word createWord(WordRequestDTO dto) {
        Word word = new Word();
        word.setSpelling(dto.getSpelling());
        word.setMeaning(dto.getMeaning());
        word.setPartOfSpeech(dto.getPartOfSpeech());

        LanguageProject project = languageProjectRepository
                .findById(dto.getLanguageProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found."));
        word.setLanguageProject(project);

        List<Morpheme> morphemes = morphemeRepository.findAllById(dto.getMorphemeIds());
        word.setMorphemesInWord(morphemes);

        return wordRepository.save(word);
    }

    public List<Word> getWordsByProjectId(Long id) {
        return wordRepository.findByLanguageProjectId(id);
    }

    public void deleteById(Long id) {
        wordRepository.deleteById(id);
    }
}
