package pbl_module.conlang_creator.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pbl_module.conlang_creator.enums.PhonemeCategory;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PhonemeRequestDTO {
    private String symbol;
    private String ipa;
    private PhonemeCategory category;
    private Long languageProjectID;
}
