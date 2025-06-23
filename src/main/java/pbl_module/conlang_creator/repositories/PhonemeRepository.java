package pbl_module.conlang_creator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pbl_module.conlang_creator.model.Phoneme;

import java.util.List;

public interface PhonemeRepository extends JpaRepository<Phoneme, Long> {
    List<Phoneme> findByLanguageProjectId(Long projectId);
}
