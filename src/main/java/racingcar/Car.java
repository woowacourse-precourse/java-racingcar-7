package racingcar;

import java.util.*;

public class Car {

    private String carName;
    private int racingCount = 0;
    private Map<Integer, List<String>> result = new HashMap<>();

    public Car(String carName) {
        this.carName = carName;
    }

    public Car() {
    }

    public int getRacingCount() {
        return racingCount;
    }

    public String getCarName() {
        return carName;
    }

    public void drive(boolean canMove) {
        if (canMove) {
            racingCount++;
        }
    }

    public void showRacingCarCompetition() {
        System.out.println(carName + " : " + "-".repeat(racingCount));
    }
}
