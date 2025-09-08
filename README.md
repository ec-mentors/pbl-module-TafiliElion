
# Conlang Creator

Conlang Creator is a Spring Boot web application for designing constructed languages (conlangs).
It allows users to define phonemes, morphemes, and words, and then connect them together in an intuitive workflow.

## Features

- **Language Projects**
  - Create and manage multiple conlang projects
  - Each project contains its own words, phonemes, and morphemes

- **Words**
  - Add, list, and delete words
  - Assign meanings and parts of speech (enum-based)
  - Ensure morphemes used in a word belong to the same project

- **Morphemes**
  - Add, list, and delete morphemes
  - Define their type (enum-based)
  - Link morphemes to phonemes

- **Phonemes**
  - Add, list, and delete phonemes
  - Define their category (enum-based)
  - Store IPA symbols

- **Validation Rules**
  - Prevent duplicate words/morphemes in the same project
  - Prevent deletion of projects if they still have associated entities
  - Confirmation before deleting entities

- **UI** (Thymeleaf + CSS)
  - Simple, server-side rendered UI
  - Styled consistently with a single `styles.css`
  - Separate screens for managing projects, words, morphemes, and phonemes

---

## Screenshots

### Project List
![Project List](docs/project_list.png)

### Add Word
![Add Word](docs/add_word.png)

### Morpheme List
![Morpheme List](docs/morpheme_list.png)

### Add Phoneme
![Add Phoneme](docs/add_phoneme.png)

---

## Tech Stack

- **Backend:** Spring Boot (3.5.x), Spring Data JPA
- **Frontend:** Thymeleaf, HTML, CSS
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Other:** Lombok

## Getting Started

### Prerequisites

- Java 23+
- Maven 3.9+
- PostgreSQL (configured in `application.properties`)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/TafiliElion/conlang-creator.git
   cd conlang-creator
   ```

2. Configure database connection in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/conlang_creator
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Open the app in your browser:
   ```
   http://localhost:8080
   ```

---

## Future Improvements

- Word generation based on syllable templates (e.g. CVC, CVV)
- Export/import projects
- User authentication and multi-user support
