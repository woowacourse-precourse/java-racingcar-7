package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int START_POSITION = 0;

    private String carName;
    private int postion;

    public Car(String carName) {
        this.carName = carName;
        this.postion = START_POSITION;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPostion() {
        return this.postion;
    }

    public void movePostion() {
        int randomNumber = generateRandomNumber();
        if (isSatisfy(randomNumber)) {
            this.postion++;
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean isSatisfy(int randomNumber) {
        return randomNumber >= 4;
    }

}
