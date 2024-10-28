package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private static int startNum = 0;
    private static int endNum = 9;

    private String name;
    private int randomNumber;
    private int currentPos;

    public Car(String name) {
        this.name = name;
        this.randomNumber = 0;
        this.currentPos = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void incCurrentPos() {
        this.currentPos++;
    }

    @Override
    public int compareTo(Car o) {
        return o.currentPos - this.getCurrentPos();
    }

    public int setAndReturnRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(startNum, endNum);
        return this.randomNumber;
    }
}
