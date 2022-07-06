package kpac.service;

import java.util.List;
import kpac.model.KnowledgePackage;

public interface KnowledgePackageService {
    void delete(Long id);

    List<KnowledgePackage> getAll();

    KnowledgePackage create(KnowledgePackage knowledgePackage);
}
