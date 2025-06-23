package pbl_module.conlang_creator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pbl_module.conlang_creator.model.Word;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByLanguageProjectId(Long projectId);
}
