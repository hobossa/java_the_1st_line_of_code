package TryEnum;

public enum Color4 implements IMessage{
    RED("red") {
        @Override
        public String getTitle() {
            return "color3 : " + this;
        }
    },
    GREEN("green") {
        @Override
        public String getTitle() {
            return "color3 : " + this;
        }
    },
    BLUE("blue") {
        @Override
        public String getTitle() {
            return "color3 : " + this;
        }
    };
    private String title;

    private Color4(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
