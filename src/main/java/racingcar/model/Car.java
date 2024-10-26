package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int CAN_MOVE_NUM = 4;
    private static final int RANDOM_START_NUM = 0;
    private static final int RANDOM_END_NUM = 9;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= CAN_MOVE_NUM) {
            this.position++;
        }
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_NUM,RANDOM_END_NUM);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
