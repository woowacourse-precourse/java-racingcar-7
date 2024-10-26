package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        boolean canMove = canMove();
        if (canMove) {
            position++;
        }
    }

    private boolean canMove() {
        int randomValue = generateRandomValue();
        return randomValue >= 4;
    }

    private int generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9); // 0 to 9
    }
}
