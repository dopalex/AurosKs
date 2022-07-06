package kpac.dto;

import java.time.LocalDate;
import javax.validation.constraints.Size;

public class KnowledgePackageRequestDto {
    @Size(max = 250)
    private String title;
    @Size(max = 2000)
    private String description;
    private LocalDate creationDate;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
