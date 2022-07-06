package kpac.mapper;

import kpac.dto.KnowledgePackageSetRequestDto;
import kpac.dto.KnowledgePackageSetResponseDto;
import kpac.model.KnowledgePackageSet;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageSetMapper {
    public KnowledgePackageSetResponseDto toDto(KnowledgePackageSet knowledgePackageSet) {
        KnowledgePackageSetResponseDto knowledgePackageSetResponseDto
                = new KnowledgePackageSetResponseDto();
        knowledgePackageSetResponseDto.setId(knowledgePackageSet.getId());
        knowledgePackageSetResponseDto.setTitle(knowledgePackageSet.getTitle());
        return knowledgePackageSetResponseDto;
    }

    public KnowledgePackageSet toModel(KnowledgePackageSetRequestDto dto) {
        KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
        knowledgePackageSet.setTitle(dto.getTitle());
        return knowledgePackageSet;
    }
}
