package hrms.wapi.base;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import af.base.dao.BaseDao;

@Service("hrms.simpleDaoService")
public class HrmsSimpleDaoService {

    @Autowired
    @Qualifier("hrms.baseDao")
    protected BaseDao baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#find(java.lang.Object)
     */
    public <T> T find(T entity) {
        return baseDao.find(entity);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#insert(boolean, java.lang.Object)
     */
    public int insert(boolean checkAffectedRowNum, Object entity) {
        return baseDao.insert(checkAffectedRowNum, entity);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#insert(boolean, java.lang.Object[])
     */
    public int[] insert(boolean checkAffectedRowNum, Object... entities) {
        return baseDao.insert(checkAffectedRowNum, entities);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#delete(boolean, java.lang.Object)
     */
    public int delete(boolean checkAffectedRowNum, Object entity) {
        return baseDao.delete(checkAffectedRowNum, entity);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#delete(boolean, java.lang.Object[])
     */
    public int[] delete(boolean checkAffectedRowNum, Object... entities) {
        return baseDao.delete(checkAffectedRowNum, entities);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#update(boolean, java.lang.Object)
     */
    public int update(boolean checkAffectedRowNum, Object entity) {
        return baseDao.update(checkAffectedRowNum, entity);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#update(boolean, java.lang.Object[])
     */
    public int[] update(boolean checkAffectedRowNum, Object... entities) {
        return baseDao.update(checkAffectedRowNum, entities);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#deleteFree(java.lang.Object, java.lang.String[])
     */
    public int deleteFree(boolean checkAffectedRowNum, Object entity, String... whereColumns) {
        return baseDao.deleteFree(checkAffectedRowNum, entity, whereColumns);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#deleteFree(java.lang.Object[], java.lang.String[])
     */
    public int[] deleteFree(boolean checkAffectedRowNum, Object[] entities, String... whereColumns) {
        return baseDao.deleteFree(checkAffectedRowNum, entities, whereColumns);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#updateFree(java.lang.Object, java.lang.String[], java.lang.String[])
     */
    public int updateFree(boolean checkAffectedRowNum, Object entity, String[] setColumns, String... whereColumns) {
        return baseDao.updateFree(checkAffectedRowNum, entity, setColumns, whereColumns);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#updateFree(java.lang.Object[], java.lang.String[], java.lang.String[])
     */
    public int[] updateFree(boolean checkAffectedRowNum, Object[] entities, String[] setColumns, String... whereColumns) {
        return baseDao.updateFree(checkAffectedRowNum, entities, setColumns, whereColumns);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#selectOne(java.lang.String, java.lang.Object, java.lang.String)
     */
    public <T> T selectOne(String statementName, Object parameter, String order) {
        return baseDao.selectOne(statementName, parameter, order);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#selectList(java.lang.String, java.lang.Object, java.lang.String)
     */
    public <T> List<T> selectList(String statementName, Object parameter, String order) {
        return baseDao.selectList(statementName, parameter, order);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#selectList(java.lang.String, java.lang.Object, int, int, java.lang.String)
     */
    public <T> List<T> selectList(String statementName, Object parameter, int start, int limit, String order) {
        return baseDao.selectList(statementName, parameter, start, limit, order);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#selectList(java.lang.String, java.lang.Object, int, int, java.lang.String, java.util.List)
     */
    public <T> int selectList(String statementName, Object parameter, int start, int limit, String order, List<T> container) {
        return baseDao.selectList(statementName, parameter, start, limit, order, container);
    }

    /*
     * (non-Javadoc)
     * @see af.base.dao.BaseDao#execute(java.lang.String, java.lang.Object)
     */
    public int execute(String statementName, Object parameter) {
        return baseDao.execute(statementName, parameter);
    }




}
