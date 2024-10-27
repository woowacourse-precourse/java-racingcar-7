package racingcar.model;

import racingcar.util.NumberGenerator;

public class Car implements Comparable<Car> {
    public static final int INITIAL_POSITION = 0;
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_MOVE_VALUE = 4;

    private final NumberGenerator numberGenerator;
    public final String name;
    private int position;

    private Car(NumberGenerator numberGenerator, String name) {
        validateName(name);
        this.numberGenerator = numberGenerator;
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public static Car of(NumberGenerator numberGenerator, String name) {
        return new Car(numberGenerator, name);
    }

    public void tryMove() {
        if (isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.position, other.position);
    }

    private static void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isMovable() {
        int randomNumber = numberGenerator.generate();
        return randomNumber >= MIN_MOVE_VALUE;
    }
}
