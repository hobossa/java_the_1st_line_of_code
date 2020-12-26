package TryDaoModel;

import java.sql.Connection;

public class DAOFactory {
    public static IEmpDAO getIEmpDAOInstance(Connection connection) {
        return new EmpDAOSqliteImpl(connection);
    }
}
