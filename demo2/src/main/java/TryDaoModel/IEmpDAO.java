package TryDaoModel;

import java.util.List;
import java.util.Set;

public interface IEmpDAO {
    /**
     * Insert a Emp into the table
     *
     * @param vo the object be inserted to the table.
     * @return true means success, false means failed
     * @throws Exception
     */
    public boolean doCreate(Emp vo) throws Exception;

    /**
     * update the item which has the same id as vo
     *
     * @param vo contains the new information. vo.eid must be valid
     * @return true menas success, else false.
     * @throws Exception
     */
    public boolean doUpdate(Emp vo) throws Exception;

    /**
     * remove the data whose id is in ids
     *
     * @param ids the id list of the data which need to be remove
     * @return true means successfully removed all rows, else false
     * @throws Exception
     */
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception;

    /**
     * find a data by id
     *
     * @param id
     * @return return the vo, or null
     * @throws Exception
     */
    public Emp findById(Integer id) throws Exception;

    /**
     * return all rows
     *
     * @return all rows or an empty list.
     * @throws Exception
     */
    public List<Emp> findAll() throws Exception;

    /**
     *
     * @param currentPage
     * @param lineSize
     * @param column
     * @param KeyWord
     * @return
     * @throws Exception
     */
    public List<Emp> findAllSplit(Integer currentPage, Integer lineSize,
                                  String column, String KeyWord) throws Exception;

    /**
     * count the data which match an certain request
     * @param column the column that be searched
     * @param keyWord
     * @return the number of data match the request
     * @throws Exception
     */
    public Integer getAllCount(String column, String keyWord) throws Exception;
}
