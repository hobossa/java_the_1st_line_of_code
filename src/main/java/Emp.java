// employee
public class Emp {
    private int empno;
    private String name;
    private String job;
    private double sal;     // salary
    private double comm;    // commission 佣金

    public Emp() {
    }

    public Emp(int empno, String name, String job, double sal, double comm) {
        this.empno = empno;
        this.name = name;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public String getInfo() {
        return "雇员编号：" + empno + "\n" +
                "雇员姓名：" + name + "\n" +
                "雇员职位：" + job + "\n" +
                "基本工资：" + sal  + "\n" +
                "佣金：" + comm;
    }
}
