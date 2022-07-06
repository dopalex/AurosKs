package kpac.service;

import java.util.List;
import kpac.dao.KnowledgePackageSetDao;
import kpac.model.KnowledgePackageSet;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {
    private final KnowledgePackageSetDao knowledgePackageSetDao;

    public KnowledgePackageSetServiceImpl(KnowledgePackageSetDao knowledgePackagSetDao) {
        this.knowledgePackageSetDao = knowledgePackagSetDao;
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        return knowledgePackageSetDao.getAll();
    }

    @Override
    public KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet) {
        return knowledgePackageSetDao.create(knowledgePackageSet);
    }

    @Override
    public void delete(Long id) {
        knowledgePackageSetDao.delete(id);
    }
}
