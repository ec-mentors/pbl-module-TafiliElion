package pbl_module.conlang_creator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pbl_module.conlang_creator.enums.PhonemeCategory;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Phoneme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private String ipa;

    @Enumerated(EnumType.STRING)
    private PhonemeCategory category;

    @ManyToOne
    private LanguageProject languageProject;
}
