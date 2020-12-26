package TryDaoModel;

import java.util.Date;

public class TestEmpInsert {
    public static void main(String[] args) throws Exception {
//        Emp vo = new Emp();
//        vo.setEmpno(8889);
//        vo.setEname("Xinhua Li");
//        vo.setJob("Teacher");
//        vo.setHiredate(new Date());
//        vo.setSal(8900.00);
//        vo.setComm(5600.0);
//        System.out.println(ServiceFactory.getIEmpServiceInstance().insert(vo));
        for (int i = 0; i < 100; i++) {
            Emp vo = new Emp();
            vo.setEmpno(100001 + i);
            vo.setEname("fake employee " + String.valueOf(1 + i));
            vo.setJob("Teacher");
            vo.setHiredate(new Date());
            vo.setSal(10001.00 + i);
            vo.setComm(5601.0 + i);
            ServiceFactory.getIEmpServiceInstance().insert(vo);
        }
    }
}
