package org.wwpmo.wsims.service;

public interface UniqueNumberService {

    String getNextUniqueNumber(int searchId) throws Exception;

    boolean getUpdateNext(int searchId)throws Exception;

}
