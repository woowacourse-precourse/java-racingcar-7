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

    public Car(Name name, racingcar.domain.NumberGenerator numberGenerator) {
        this.name = name;
        NumberGenerator = numberGenerator;
    }

    public void move() {
        final int number = NumberGenerator.generate();
        if (number >= 4) {
            distance++;
        }
    }

    public String getName() {
        return name.value();
    }

    public int getDistance() {
        return distance;
    }
}
