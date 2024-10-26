package racingcar;

import racingcar.util.NumberGenerator;

public class Car {
    private final NumberGenerator numberGenerator;
    private final String name;
    private int position;

    public Car(NumberGenerator numberGenerator, String name) {
        if (name.length() > 5 || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.numberGenerator = numberGenerator;
        this.name = name;
        this.position = 0;
    }

    public void tryMove() {
        int randomNumber = numberGenerator.generate();
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
