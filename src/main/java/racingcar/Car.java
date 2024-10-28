package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void moveForwardOrNot() {
        if (randomNumber() > 3) {
            location++;
        }
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    @Override
    public int compareTo(Car car) {
        if (location > car.location) {
            return -1;
        } else if (location < car.location) {
            return 1;
        }
        return 0;
    }
}
