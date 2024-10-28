package racingcar;

import racingcar.util.RandomNumberGenerator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private static final int STANDARD_NUMBER = 4;

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (RandomNumberGenerator.generateRandomNumber() >= STANDARD_NUMBER) {
            distance++;
        }
    }

    public void show() {
        String result = name + " : " + IntStream.range(0, distance)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
        System.out.println(result);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
