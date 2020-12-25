package TryDaoModel;

public interface ServiceFactory {
    public static IEmpService getIEmpServiceInstance() {
        return new EmpServiceImpl();
    }
}
