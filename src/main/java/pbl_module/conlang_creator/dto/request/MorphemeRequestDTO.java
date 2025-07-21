package pbl_module.conlang_creator.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MorphemeRequestDTO {
    private String form;
    private String meaning;
    private String type;
    private Long languageProjectId;
    private List<Long> phonemeIds;
}

