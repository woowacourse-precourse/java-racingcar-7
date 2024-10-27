package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이여야 합니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean shouldMove) {
        if (shouldMove) {
            position++;
        }
    }

    public String getPositionRepresentation() {
        return "-".repeat(position);
    }
}
