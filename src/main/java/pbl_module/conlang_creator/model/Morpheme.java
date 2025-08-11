package pbl_module.conlang_creator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pbl_module.conlang_creator.enums.MorphemeType;

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

    @Enumerated(EnumType.STRING)
    private MorphemeType type;

    @ManyToOne
    private LanguageProject languageProject;

    @ManyToMany
    private List<Phoneme> phonemesInMorpheme;
}
