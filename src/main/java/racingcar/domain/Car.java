package racingcar.domain;

public class Car {
    private final Name name;
    private int distance;
    private final NumberGenerator NumberGenerator;

    public Car(racingcar.domain.NumberGenerator numberGenerator, int distance, String name) {
        NumberGenerator = numberGenerator;
        this.distance = distance;
        this.name = Name.from(name);
    }

    public void move() {
        final int number = NumberGenerator.generate();
        if (number > 4) {
            distance++;
        }
    }

    public Name getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
