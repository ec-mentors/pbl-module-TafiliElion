package pbl_module.conlang_creator.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PhonemeRequestDTO {
    private String symbol;
    private String ipa;
    private String category;
    private Long languageProjectID;
}
