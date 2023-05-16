package cn.cvs.service.impl;

import cn.cvs.dao.tStorageRecord.TStorageRecordMapper;
import cn.cvs.service.TStorageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/15 17:28
 **/
@Transactional
@Service("storageRecordService")
public class TStorageRecordServiceImpl implements TStorageRecordService {
    @Autowired
    private TStorageRecordMapper storageRecordMapper;

    public void setStorageRecordMapper(TStorageRecordMapper storageRecordMapper) {
        this.storageRecordMapper = storageRecordMapper;
    }
}
