package kpac.dao;

import java.util.List;
import kpac.model.KnowledgePackage;

public interface KnowledgePackageDao {
    List<KnowledgePackage> getAll();

    KnowledgePackage create(KnowledgePackage knowledgePackage);

    void delete(Long id);
}
