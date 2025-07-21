package pbl_module.conlang_creator.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LanguageProjectRequestDTO {
    private String name;
    private String description;
}
