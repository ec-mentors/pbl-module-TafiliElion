package pbl_module.conlang_creator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class WordRequestDTO {
    private String spelling;
    private String meaning;
    private String partOfSpeech;
    private Long languageProjectId;
    private List<Long> morphemeIds;
}
