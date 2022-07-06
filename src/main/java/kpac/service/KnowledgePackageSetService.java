package kpac.service;

import java.util.List;
import kpac.model.KnowledgePackageSet;

public interface KnowledgePackageSetService {
    List<KnowledgePackageSet> getAll();

    KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet);

    void delete(Long id);
}
