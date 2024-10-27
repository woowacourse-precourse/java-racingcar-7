package racingcar.model;

import racingcar.config.GameConfig;
import racingcar.util.RandomNumberGenerator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private final String name;
    private final int forwardNumber;

    private Car(String name, int forwardNumber) {
        this.name = name;
        this.forwardNumber = forwardNumber;
    }

    public static Car of(String name, int forward) {
        return new Car(name, forward);
    }

    public static Car of(String name) {
        return of(name, 0);
    }

    public Car play() {
        int randomNumber = RandomNumberGenerator.generateNumber();
        if (isForward(randomNumber)) {
            return of(name, forwardNumber + 1);
        }
        return this;
    }

    public boolean isMaxForwardNumber(int forwardNumber) {
        return this.forwardNumber > forwardNumber;
    }

    public int getForwardNumber() {
        return this.forwardNumber;
    }

    public boolean isWinner(int maxForwardNumber) {
        return this.forwardNumber == maxForwardNumber;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String forwardNumberToString = getForwardNumberToString();
        return this.name + " : " + forwardNumberToString;
    }

    private String getForwardNumberToString() {
        return IntStream.range(0, forwardNumber)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= GameConfig.POSSIBLE_FORWARD_NUMBER;
    }
}
