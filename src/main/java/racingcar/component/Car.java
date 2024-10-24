package racingcar.component;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Car {
    private final String name;

    private int position;

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

    public boolean checkWinner(int maxPosition) {
        return position == maxPosition;
    }

    public void printPosition() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
