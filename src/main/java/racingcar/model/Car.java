package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int START_POSITION = 0;

    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = START_POSITION;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }


    public void movePosition() {
        if (isSatisfy(generateRandomNumber())) {
            this.position++;
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean isSatisfy(int randomNumber) {
        return randomNumber >= 4;
    }

}
