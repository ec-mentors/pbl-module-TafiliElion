package pbl_module.conlang_creator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spelling;
    private String meaning;
    private String partOfSpeech;

    @ManyToOne
    private LanguageProject languageProject;

    @ManyToMany
    @JoinTable (
            name = "word_morpheme",
            joinColumns = @JoinColumn(name = "word_id"),
            inverseJoinColumns = @JoinColumn(name = "morpheme_id")
    )
    private List<Morpheme> morphemesInWord;
}
