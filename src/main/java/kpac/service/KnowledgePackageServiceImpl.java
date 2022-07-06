package kpac.service;

import java.util.List;
import kpac.dao.KnowledgePackageDao;
import kpac.model.KnowledgePackage;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageServiceImpl implements KnowledgePackageService {
    private final KnowledgePackageDao knowledgePackageDao;

    public KnowledgePackageServiceImpl(KnowledgePackageDao knowledgePackageDao) {
        this.knowledgePackageDao = knowledgePackageDao;
    }

    @Override
    public List<KnowledgePackage> getAll() {
        return knowledgePackageDao.getAll();
    }

    @Override
    public KnowledgePackage create(KnowledgePackage knowledgePackage) {
        return knowledgePackageDao.create(knowledgePackage);
    }

    @Override
    public void delete(Long id) {
        knowledgePackageDao.delete(id);
    }
}
