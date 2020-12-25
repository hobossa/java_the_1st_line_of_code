package TryDaoModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IEmpService {
    public boolean insert(Emp vo) throws Exception;

    public boolean update(Emp vo) throws Exception;

    public boolean delete(Set<Integer> ids) throws Exception;

    public Emp get(int ids) throws Exception;

    public List<Emp> list() throws Exception;

    public Map<String, Object> list(int currentPage, int lineSize,
                                    String column, String keyWord) throws Exception;
}
