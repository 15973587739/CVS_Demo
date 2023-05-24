package cn.cvs.service.impl;

import cn.cvs.dao.tStorageRecord.TStorageRecordMapper;
import cn.cvs.pojo.TStorageRecord;
import cn.cvs.service.TStorageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/15 17:28
 **/
@Transactional
@Service("storageRecordService")
public class TStorageRecordServiceImpl implements TStorageRecordService {
    @Resource
    private TStorageRecordMapper storageRecordMapper;

    public void setStorageRecordMapper(TStorageRecordMapper storageRecordMapper) {
        this.storageRecordMapper = storageRecordMapper;
    }

    @Override
    public List<TStorageRecord> queryRecord() {
        try {
            return storageRecordMapper.queryRecord();
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TStorageRecord> queryWithRecord(TStorageRecord tStorageRecord) {
        try {
            return storageRecordMapper.queryWithRecord(tStorageRecord);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TStorageRecord> queryRecordMap(TStorageRecord tStorageRecord) {
        try {
            return storageRecordMapper.queryRecordMap(tStorageRecord);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TStorageRecord> getStorageRecordArray(List<Integer> supplierId) {
        try {
            return storageRecordMapper.getStorageRecordArray(supplierId);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TStorageRecord> getStorageRecordMap(Map<String, Object> supplier) {
        try {
            return storageRecordMapper.getStorageRecordMap(supplier);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TStorageRecord queryById(Long id) {
        try {
            return storageRecordMapper.queryById(id);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TStorageRecord> selectPageList(Integer pageBegin, Integer pageSize) {
        try {
            return storageRecordMapper.selectPageList(pageBegin,pageSize);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TStorageRecord> queryAllByLimit(TStorageRecord tStorageRecord, Integer pageBegin, Integer pageSize) {
        try {
            return storageRecordMapper.queryAllByLimit(tStorageRecord,pageBegin,pageSize);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public long count(TStorageRecord tStorageRecord) {
        try {
            return storageRecordMapper.count(tStorageRecord);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public int insert(TStorageRecord tStorageRecord) {
        int count = 0;
        try {
            count = storageRecordMapper.insert(tStorageRecord);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    @Override
    public int insertBatch(List<TStorageRecord> entities) {
        int count = 0;
        try {
            count = storageRecordMapper.insertBatch(entities);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    @Override
    public int insertOrUpdateBatch(List<TStorageRecord> entities) {
        int count = 0;
        try {
            count = storageRecordMapper.insertOrUpdateBatch(entities);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    @Override
    public int update(TStorageRecord tStorageRecord) {
        int count = 0;
        try {
            count = storageRecordMapper.update(tStorageRecord);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    @Override
    public int deleteById(Long id) {
        int count = 0;
        try {
            count = storageRecordMapper.deleteById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }
}
