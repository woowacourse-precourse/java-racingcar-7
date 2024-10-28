package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;
    private final RandomNumberGenerator randomNumberGenerator;

    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void move() {
        int randomValue = randomNumberGenerator.generate();
        if (randomValue >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
