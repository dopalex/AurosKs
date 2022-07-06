package kpac.controller;

import java.util.List;
import java.util.stream.Collectors;
import kpac.dto.KnowledgePackageRequestDto;
import kpac.dto.KnowledgePackageResponseDto;
import kpac.mapper.KnowledgePackageMapper;
import kpac.model.KnowledgePackage;
import kpac.service.KnowledgePackageService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kpacs")
public class KnowledgePackageController {
    private final KnowledgePackageMapper knowledgePackageMapper;
    private final KnowledgePackageService knowledgePackageService;

    public KnowledgePackageController(KnowledgePackageService knowledgePackageService,
            KnowledgePackageMapper knowledgePackageMapper) {
        this.knowledgePackageMapper = knowledgePackageMapper;
        this.knowledgePackageService = knowledgePackageService;
    }

    @PostMapping
    public KnowledgePackageResponseDto create(
            @RequestBody KnowledgePackageRequestDto dto) {
        KnowledgePackage knowledge = knowledgePackageMapper.toModel(dto);
        return knowledgePackageMapper.toDto(knowledgePackageService.create(knowledge));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        knowledgePackageService.delete(id);
    }

    @GetMapping
    public List<KnowledgePackageResponseDto> getAll() {
        return knowledgePackageService.getAll().stream()
                .map(knowledgePackageMapper::toDto)
                .collect(Collectors.toList());
    }
}
