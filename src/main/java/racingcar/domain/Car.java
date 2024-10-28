package racingcar.domain;

public class Car {
    private static final int MOVED_BOUND = 4;
    private static final String POSITION_FORMAT_SYMBOL = "-";
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVED_BOUND) {
            position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getCurrentStateFormat() {
        String stateFormat = "%s : %s";
        String positionFormat = POSITION_FORMAT_SYMBOL.repeat(position);
        return String.format(stateFormat, name, positionFormat);
    }
}

