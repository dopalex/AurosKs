package kpac.model;

import java.time.LocalDate;

public class KnowledgePackage {
    private Long id;
    private String title;
    private String description;
    private LocalDate creationDate;

    public KnowledgePackage() {
        creationDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "KnowledgePackage{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", description='" + description + '\''
                + ", creationDate=" + creationDate
                + '}';
    }
}
