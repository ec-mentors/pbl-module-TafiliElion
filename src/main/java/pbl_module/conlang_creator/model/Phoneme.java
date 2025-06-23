package pbl_module.conlang_creator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Phoneme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private String ipa;
    private String category;

    @ManyToOne
    private LanguageProject languageProject;
}
