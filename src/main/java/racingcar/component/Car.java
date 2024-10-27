package racingcar.component;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    @Override
    public String toString() {
        return name;
    }

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static List<Car> makeListFrom(String carsString) {
        return Arrays.stream(carsString.split(","))
                .map(Car::new)
                .toList();
    }

    public void moveOrNot() {
        if (canMove()) {
            move();
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private void move() {
        position++;
    }

    public boolean isSamePosition(Car other) {
        return position == other.position;
    }

    public void printPosition() {
        System.out.println(name + " : " + "-".repeat(position));
    }
}
