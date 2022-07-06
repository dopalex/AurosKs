package kpac.controller;

import java.util.List;
import java.util.stream.Collectors;
import kpac.dto.KnowledgePackageSetRequestDto;
import kpac.dto.KnowledgePackageSetResponseDto;
import kpac.mapper.KnowledgePackageSetMapper;
import kpac.model.KnowledgePackageSet;
import kpac.service.KnowledgePackageSetService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sets")
public class KnowledgePackageSetController {
    private final KnowledgePackageSetService knowledgePackageSetService;
    private final KnowledgePackageSetMapper knowledgePackageSetMapper;

    public KnowledgePackageSetController(KnowledgePackageSetService knowledgePackageSetService,
                                         KnowledgePackageSetMapper knowledgePackageSetMapper) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageSetMapper = knowledgePackageSetMapper;
    }

    @GetMapping
    public List<KnowledgePackageSetResponseDto> getAll() {
        return knowledgePackageSetService.getAll().stream()
                .map(knowledgePackageSetMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public KnowledgePackageSetResponseDto create(
            @RequestBody KnowledgePackageSetRequestDto dto) {
        KnowledgePackageSet set = knowledgePackageSetMapper.toModel(dto);
        return knowledgePackageSetMapper.toDto(knowledgePackageSetService.create(set));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        knowledgePackageSetService.delete(id);
    }
}
