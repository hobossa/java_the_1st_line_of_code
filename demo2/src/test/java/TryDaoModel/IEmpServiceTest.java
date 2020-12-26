package TryDaoModel;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class IEmpServiceTest {
    private static int empno;
    static {
        empno = new Random().nextInt(10000000);
    }

    @Test
    public void insert() {
        Emp vo = new Emp();
        vo.setEmpno(empno);
        vo.setEname("Han Meimei");
        vo.setJob("Tutor");
        vo.setHiredate(new Date());
        vo.setSal(10000.0);
        vo.setComm(0.5);
        try {
            TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().insert(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        Emp vo = new Emp();
        vo.setEmpno(8889);
        vo.setEname("Han");
        vo.setJob("Laborer");
        vo.setHiredate(new Date());
        vo.setSal(10000.0);
        vo.setComm(0.5);
        try {
            TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().update(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        Set<Integer> ids = new HashSet<>();
        ids.add(8889);
        try {
            TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().delete(ids));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get() {
        try {
            TestCase.assertNotNull(ServiceFactory.getIEmpServiceInstance().get(8889));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void list() {
        try {
            TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().list().size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void listIntIntStringString() {
        try {
            Map<String, Object> map = ServiceFactory.getIEmpServiceInstance()
                    .list(2, 5, "ename", "");
            int count = (Integer)map.get("empCount");
            List<Emp> all = (List<Emp>)map.get("allEmps");
            TestCase.assertTrue(count > 0 && all.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}