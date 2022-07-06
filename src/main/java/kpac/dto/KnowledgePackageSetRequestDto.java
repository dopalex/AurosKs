package kpac.dto;

import javax.validation.constraints.Size;

public class KnowledgePackageSetRequestDto {
    @Size(max = 250)
    private String title;

    public String getTitle() {
        return title;
    }
}
