package pbl_module.conlang_creator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pbl_module.conlang_creator.model.Morpheme;


public interface MorphemeRepository extends JpaRepository<Morpheme, Long> {
}
