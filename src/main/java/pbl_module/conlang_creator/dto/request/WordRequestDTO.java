package pbl_module.conlang_creator.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pbl_module.conlang_creator.enums.PartOfSpeech;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class WordRequestDTO {
    private String spelling;
    private String meaning;
    private PartOfSpeech partOfSpeech;
    private Long languageProjectId;
    private List<Long> morphemeIds = new ArrayList<>();
}
