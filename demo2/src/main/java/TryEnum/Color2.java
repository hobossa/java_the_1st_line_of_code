package TryEnum;

public enum Color2 {
    RED("color2 : red"), GREEN("color2 : green"), BLUE("color2 : blue");
    private String title;

    private Color2(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
