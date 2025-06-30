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

public class Morpheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String form;
    private String meaning;
    private String type;

    @ManyToOne
    private LanguageProject languageProject;

    @ManyToMany
    @JoinTable (
            name = "morpheme_phoneme",
            joinColumns = @JoinColumn(name = "morpheme_id"),
            inverseJoinColumns = @JoinColumn(name = "phoneme_id")
    )
    private List<Phoneme> phonemesInMorpheme;
}
