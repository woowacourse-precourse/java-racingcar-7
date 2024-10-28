package racingcar.model;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(boolean shouldMove) {
        if (shouldMove) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionSymbols() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < position; i++) {
            str.append("-");
        }

        return str.toString();
    }
}
