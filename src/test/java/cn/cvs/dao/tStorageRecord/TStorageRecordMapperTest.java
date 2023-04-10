package cn.cvs.dao.tStorageRecord;

import cn.cvs.pojo.TStorageRecord;
import cn.cvs.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TStorageRecordMapperTest {

    /**
     * 查询入库记录
     */
    @Test
    public void queryRecord() {
        SqlSession sqlSession=null;
        List<TStorageRecord> recordList = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            TStorageRecord record = new TStorageRecord();
            record.setSupplierId(3L);
            record.setGoodsName("米");
            record.setPayStatus(2);
            recordList=sqlSession.getMapper(TStorageRecordMapper.class).queryRecord(record);
            recordList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void queryById() {
    }

    @Test
    public void queryAllByLimit() {
    }

    @Test
    public void count() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertBatch() {
    }

    @Test
    public void insertOrUpdateBatch() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }
}