package racingcar.domain;

public class Car {

    private static final int START_COUNT = 0;
    private static final int DEFAULT_RANDOM_NUMBER = 0;

    private final String name;
    private int randomNumber;
    private int winCount;

    public Car(String name) {
        this.name = name;
        this.randomNumber = DEFAULT_RANDOM_NUMBER;
        this.winCount = START_COUNT;
    }

}
