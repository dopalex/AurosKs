package kpac.dao;

import java.util.List;
import kpac.model.KnowledgePackageSet;

public interface KnowledgePackageSetDao {
    List<KnowledgePackageSet> getAll();

    KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet);

    void delete(Long id);
}
