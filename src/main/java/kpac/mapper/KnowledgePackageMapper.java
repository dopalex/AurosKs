package kpac.mapper;

import java.time.LocalDate;
import kpac.dto.KnowledgePackageRequestDto;
import kpac.dto.KnowledgePackageResponseDto;
import kpac.model.KnowledgePackage;
import kpac.service.KnowledgePackageService;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageMapper {
    private final KnowledgePackageService knowledgePackageService;

    public KnowledgePackageMapper(KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageService = knowledgePackageService;
    }

    public KnowledgePackageResponseDto toDto(KnowledgePackage knowledgePackage) {
        KnowledgePackageResponseDto dto = new KnowledgePackageResponseDto();
        dto.setId(knowledgePackage.getId());
        dto.setTitle(knowledgePackage.getTitle());
        dto.setDescription((knowledgePackage.getDescription()));
        dto.setCreationDate(knowledgePackage.getCreationDate());
        return dto;
    }

    public KnowledgePackage toModel(KnowledgePackageRequestDto dto) {
        KnowledgePackage knowledgePackage = new KnowledgePackage();
        knowledgePackage.setTitle(dto.getTitle());
        knowledgePackage.setDescription(dto.getDescription());
        knowledgePackage.setCreationDate(LocalDate.now());
        return knowledgePackage;
    }
}
