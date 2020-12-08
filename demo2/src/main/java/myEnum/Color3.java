package myEnum;

public enum Color3 implements IMessage{
    RED("color3 : red"), GREEN("color3 : green"), BLUE("color3 : blue");;
    private String title;

    private Color3(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
