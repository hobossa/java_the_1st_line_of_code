package TryDaoModel;

import java.sql.Connection;

public interface IDatabaseConnection {
    public Connection getConnection();
    public void close();
}
