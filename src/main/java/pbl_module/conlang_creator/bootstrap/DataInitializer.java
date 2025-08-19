package pbl_module.conlang_creator.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pbl_module.conlang_creator.enums.MorphemeType;
import pbl_module.conlang_creator.enums.PartOfSpeech;
import pbl_module.conlang_creator.enums.PhonemeCategory;
import pbl_module.conlang_creator.model.LanguageProject;
import pbl_module.conlang_creator.model.Morpheme;
import pbl_module.conlang_creator.model.Phoneme;
import pbl_module.conlang_creator.model.Word;
import pbl_module.conlang_creator.repositories.LanguageProjectRepository;
import pbl_module.conlang_creator.repositories.MorphemeRepository;
import pbl_module.conlang_creator.repositories.PhonemeRepository;
import pbl_module.conlang_creator.repositories.WordRepository;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final LanguageProjectRepository languageProjectRepository;
    private final MorphemeRepository morphemeRepository;
    private final PhonemeRepository phonemeRepository;
    private final WordRepository wordRepository;

    @Override
    public void run(String... args) {
        if (languageProjectRepository.count() == 0) {
            // Create a base project
            LanguageProject project = new LanguageProject();
            project.setName("Sample Project");
            project.setDescription("This is a preloaded test project.");
            languageProjectRepository.save(project);

        }

        LanguageProject project = new LanguageProject();
        project.setName("Sample Project");
        project.setDescription("Preloaded project for demo/testing.");
        project = languageProjectRepository.save(project);

        List<Phoneme> phonemes = new ArrayList<>();

        Phoneme p1 = new Phoneme();
        p1.setSymbol("p");
        p1.setIpa("[p]");
        p1.setCategory(PhonemeCategory.CONSONANT);
        p1.setLanguageProject(project);
        phonemes.add(p1);

        Phoneme p2 = new Phoneme();
        p2.setSymbol("t");
        p2.setIpa("[t]");
        p2.setCategory(PhonemeCategory.CONSONANT);
        p2.setLanguageProject(project);
        phonemes.add(p2);

        Phoneme p3 = new Phoneme();
        p3.setSymbol("k");
        p3.setIpa("[k]");
        p3.setCategory(PhonemeCategory.CONSONANT);
        p3.setLanguageProject(project);
        phonemes.add(p3);

        Phoneme p4 = new Phoneme();
        p4.setSymbol("a");
        p4.setIpa("[a]");
        p4.setCategory(PhonemeCategory.VOWEL);
        p4.setLanguageProject(project);
        phonemes.add(p4);

        Phoneme p5 = new Phoneme();
        p5.setSymbol("i");
        p5.setIpa("[i]");
        p5.setCategory(PhonemeCategory.VOWEL);
        p5.setLanguageProject(project);
        phonemes.add(p5);

        phonemeRepository.saveAll(phonemes);

        List<Morpheme> morphemes = new ArrayList<>();

        Morpheme m1 = new Morpheme();
        m1.setForm("pa");
        m1.setMeaning("speak");
        m1.setType(MorphemeType.ROOT);
        m1.setLanguageProject(project);
        m1.setPhonemesInMorpheme(List.of(p1, p4));
        morphemes.add(m1);

        Morpheme m2 = new Morpheme();
        m2.setForm("ti");
        m2.setMeaning("agent");
        m2.setType(MorphemeType.SUFFIX);
        m2.setLanguageProject(project);
        m2.setPhonemesInMorpheme(List.of(p2, p5));
        morphemes.add(m2);

        Morpheme m3 = new Morpheme();
        m3.setForm("ka");
        m3.setMeaning("diminutive");
        m3.setType(MorphemeType.PREFIX);
        m3.setLanguageProject(project);
        m3.setPhonemesInMorpheme(List.of(p3, p4));
        morphemes.add(m3);

        Morpheme m4 = new Morpheme();
        m4.setForm("mi");
        m4.setMeaning("beautiful");
        m4.setType(MorphemeType.INFIX);
        m4.setLanguageProject(project);
        m4.setPhonemesInMorpheme(List.of(p5));
        morphemes.add(m4);

        Morpheme m5 = new Morpheme();
        m5.setForm("na");
        m5.setMeaning("song");
        m5.setType(MorphemeType.ROOT);
        m5.setLanguageProject(project);
        m5.setPhonemesInMorpheme(List.of(p4));
        morphemes.add(m5);

        morphemeRepository.saveAll(morphemes);

        List<Word> words = new ArrayList<>();

        Word w1 = new Word();
        w1.setSpelling("pati");
        w1.setMeaning("to speak");
        w1.setPartOfSpeech(PartOfSpeech.VERB);
        w1.setLanguageProject(project);
        w1.setMorphemesInWord(List.of(m1, m2));
        words.add(w1);

        Word w2 = new Word();
        w2.setSpelling("kapa");
        w2.setMeaning("tree");
        w2.setPartOfSpeech(PartOfSpeech.NOUN);
        w2.setLanguageProject(project);
        w2.setMorphemesInWord(List.of(m3, m1));
        words.add(w2);

        Word w3 = new Word();
        w3.setSpelling("mina");
        w3.setMeaning("beautiful");
        w3.setPartOfSpeech(PartOfSpeech.ADJECTIVE);
        w3.setLanguageProject(project);
        w3.setMorphemesInWord(List.of(m4, m5));
        words.add(w3);

        Word w4 = new Word();
        w4.setSpelling("nati");
        w4.setMeaning("song");
        w4.setPartOfSpeech(PartOfSpeech.NOUN);
        w4.setLanguageProject(project);
        w4.setMorphemesInWord(List.of(m5, m2));
        words.add(w4);

        Word w5 = new Word();
        w5.setSpelling("tika");
        w5.setMeaning("quickly");
        w5.setPartOfSpeech(PartOfSpeech.ADVERB);
        w5.setLanguageProject(project);
        w5.setMorphemesInWord(List.of(m2, m3));
        words.add(w5);

        wordRepository.saveAll(words);

        System.out.println("✅ Demo data initialized: 1 project, 5 phonemes, 5 morphemes, 5 words.");

    }
}
