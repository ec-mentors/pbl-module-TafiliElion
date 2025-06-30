package pbl_module.conlang_creator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pbl_module.conlang_creator.model.Phoneme;


public interface PhonemeRepository extends JpaRepository<Phoneme, Long> {
}
