public class Robot extends Action {
    @Override
    public void eat() {
        System.out.println("机器人补充能量！");
    }

    @Override
    public void sleep() {
    }

    @Override
    public void work() {
        System.out.println("机器人正努力工作！");
    }
}
