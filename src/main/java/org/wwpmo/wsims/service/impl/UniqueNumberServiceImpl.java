package org.wwpmo.wsims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wwpmo.wsims.entities.UniqueNumber;
import org.wwpmo.wsims.repository.UniqueNumberRepository;
import org.wwpmo.wsims.service.UniqueNumberService;
import org.wwpmo.wsims.utils.SEARCH_IDS;

@Service
@Transactional
public class UniqueNumberServiceImpl implements UniqueNumberService {

    @Autowired
    private UniqueNumberRepository numberRepository;

    @Override
    public String getNextUniqueNumber(int searchId) throws Exception {
        UniqueNumber Id = numberRepository.findBySearchId(searchId);
        return Id.getSufix()+Id.getNextNumber();
    }

    @Override
    public boolean getUpdateNext(int searchId) throws Exception {
        int i = numberRepository.updateNextIndex(searchId);
        return i == 1;

    }
}
