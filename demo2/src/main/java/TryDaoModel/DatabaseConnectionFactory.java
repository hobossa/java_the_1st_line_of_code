package TryDaoModel;

import java.lang.reflect.InvocationTargetException;

public class DatabaseConnectionFactory {
    public static IDatabaseConnection getInstance(String className) {
        IDatabaseConnection conn = null;
        try {
            conn = (IDatabaseConnection) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
