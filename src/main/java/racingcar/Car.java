package racingcar;

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

    public void moveIfPossible() {
        int randomNumber = generateRandomNumber();
        if (randomNumber >= 4) {
            position++;
        }
    }

    public void moveIfPossible(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
