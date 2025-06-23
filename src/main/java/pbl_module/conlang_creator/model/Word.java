package pbl_module.conlang_creator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor


public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spelling;
    private String meaning;
    private String partOfSpeech;

    @ManyToOne
    private LanguageProject languageProject;
}
