package pbl_module.conlang_creator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pbl_module.conlang_creator.model.LanguageProject;

import java.util.List;

public interface LanguageProjectRepository extends JpaRepository<LanguageProject, Long> {
    List<LanguageProject> findLanguageProjectById(Long projectId);
}
