package pbl_module.conlang_creator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Morpheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String form;
    private String meaning;
    private String type;

    @ManyToOne
    private LanguageProject languageProject;
}
