package racingcar;

public class Player {
    private final String name;
    private int position = 0;


    public Player(String name) {
        this.name = name;
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionIndicator() {
        return "-".repeat(position);
    }
}
