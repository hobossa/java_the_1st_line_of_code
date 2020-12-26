package TryDaoModel;

import java.util.List;
import java.util.Map;

public class TestEmpSplit {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Map<String, Object> map = ServiceFactory.getIEmpServiceInstance()
                .list(1, 5, "ename", "");
        int count = (Integer)map.get("empCount");
        System.out.println("data count: " + count);
        List<Emp> all = (List<Emp>)map.get("allEmps");
        for (Emp vo: all) {
            System.out.println(vo.getEname() + ", " + vo.getJob());
        }
    }
}
