abstract class Action {
    public static final int EAT = 1;
    public static final int SLEEP = 2;
    public static final int WORK = 4;

    public void command(int flag) {
        switch (flag) {
            case EAT:
                this.eat();
                break;
            case SLEEP:
                this.sleep();
                break;
            case WORK:
                this.work();
                break;
            case EAT + WORK:
                this.eat();
                this.work();
                break;
        }
    }

    public abstract void eat();

    public abstract void sleep();

    public abstract void work();
}
