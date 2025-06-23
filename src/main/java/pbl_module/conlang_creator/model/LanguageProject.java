package pbl_module.conlang_creator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor


public class LanguageProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "languageProject", cascade = CascadeType.ALL)
    private List<Word> words;

    @OneToMany(mappedBy = "languageProject", cascade = CascadeType.ALL)
    private List<Phoneme> phonemes;

    @OneToMany(mappedBy = "languageProject", cascade = CascadeType.ALL)
    private List<Morpheme> morphemes;
}
