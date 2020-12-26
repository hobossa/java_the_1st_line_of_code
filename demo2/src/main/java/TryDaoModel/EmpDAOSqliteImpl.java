package TryDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmpDAOSqliteImpl implements IEmpDAO {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public EmpDAOSqliteImpl(Connection connection) {
        this.connection = connection;
        try {
            this.createTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTable() throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS emp (\n" +
                "    empno INTEGER PRIMARY KEY,\n" +
                "    ename TEXT,\n" +
                "    job TEXT,\n" +
                "    hiredate NUMERIC,\n" +
                "    sal REAL,\n" +
                "    comm REAL" +
                ");";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.execute();
    }

    @Override
    public boolean doCreate(Emp vo) throws Exception {
        String sql = "INSERT INTO emp(empno, ename, job, hiredate, sal, comm) VALUES (?,?,?,?,?,?);";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, vo.getEmpno());
        this.preparedStatement.setString(2, vo.getEname());
        this.preparedStatement.setString(3, vo.getJob());
        // convert java.util.Date object to java.sql.Date object
        this.preparedStatement.setDate(4, new java.sql.Date(vo.getHiredate().getTime()));
        this.preparedStatement.setDouble(5, vo.getSal());
        this.preparedStatement.setDouble(6, vo.getComm());
        return this.preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Emp vo) throws Exception {
        String sql = "UPDATE emp SET ename=?, job=?, hiredate=?, sal=?, comm=? WHERE empno=?;";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, vo.getEname());
        this.preparedStatement.setString(2, vo.getJob());
        // convert java.util.Date object to java.sql.Date object
        this.preparedStatement.setDate(3, new java.sql.Date(vo.getHiredate().getTime()));
        this.preparedStatement.setDouble(4, vo.getSal());
        this.preparedStatement.setDouble(5, vo.getComm());
        this.preparedStatement.setInt(6, vo.getEmpno());
        return this.preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        // It would be better to use database transaction
        // to ensure all data be deleted or none be deleted.
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM emp WHERE empno IN(");
        for (Integer id : ids) {
            sql.append(id).append(",");
        }
        sql.delete(sql.length() - 1, sql.length());
        sql.append(");");
        this.preparedStatement = this.connection.prepareStatement(sql.toString());
        return this.preparedStatement.executeUpdate() == ids.size();
    }

    @Override
    public Emp findById(Integer id) throws Exception {
        Emp vo = null;
        String sql = "SELECT empno, ename, job, hiredate, sal, comm FROM emp WHERE empno=?;";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, id);
        ResultSet rs = this.preparedStatement.executeQuery();
        if (rs.next()) {
            vo = new Emp();
            vo.setEmpno(rs.getInt(1));
            vo.setEname(rs.getString(2));
            vo.setJob(rs.getString(3));
            vo.setHiredate(rs.getDate(4));
            vo.setSal(rs.getDouble(5));
            vo.setComm(rs.getDouble(6));
        }
        return vo;
    }

    @Override
    public List<Emp> findAll() throws Exception {
        List<Emp> all = new ArrayList<>();
        String sql = "SELECT empno, ename, job, hiredate, sal, comm FROM emp;";
        this.preparedStatement = this.connection.prepareStatement(sql);
        ResultSet rs = this.preparedStatement.executeQuery();
        while (rs.next()) {
            Emp vo = new Emp();
            vo.setEmpno(rs.getInt(1));
            vo.setEname(rs.getString(2));
            vo.setJob(rs.getString(3));
            vo.setHiredate(rs.getDate(4));
            vo.setSal(rs.getDouble(5));
            vo.setComm(rs.getDouble(6));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Emp> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        List<Emp> all = new ArrayList<>();
        //String sql = "SELECT empno, ename, job, hiredate, sal, comm " +
        //        "FROM emp WHERE " + column + " LIKE ? LIMIT ?, ?;";
        String sql = "SELECT empno, ename, job, hiredate, sal, comm FROM emp WHERE ename LIKE ? LIMIT ?, ?;";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, "%" + keyWord + "%");
        this.preparedStatement.setInt(2, currentPage * lineSize);
        this.preparedStatement.setInt(3, lineSize);
        ResultSet rs = this.preparedStatement.executeQuery();
        while (rs.next()) {
            Emp vo = new Emp();
            vo.setEmpno(rs.getInt(1));
            vo.setEname(rs.getString(2));
            vo.setJob(rs.getString(3));
            vo.setHiredate(rs.getDate(4));
            vo.setSal(rs.getDouble(5));
            vo.setComm(rs.getDouble(6));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        String sql = "SELECT COUNT(empno) FROM emp WHERE " + column + " LIKE ?;";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, "%" + keyWord + "%");
        ResultSet rs = this.preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
