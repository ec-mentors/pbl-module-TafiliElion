package pbl_module.conlang_creator.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pbl_module.conlang_creator.model.LanguageProject;
import pbl_module.conlang_creator.repositories.LanguageProjectRepository;


@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final LanguageProjectRepository languageProjectRepository;

    @Override
    public void run(String... args) {
        if (languageProjectRepository.count() == 0) {
            LanguageProject project = new LanguageProject();
            project.setName("Sample Project");
            project.setDescription("This is a preloaded test project.");
            languageProjectRepository.save(project);
            System.out.println("✅ Language project initialized.");
        }
    }
}
