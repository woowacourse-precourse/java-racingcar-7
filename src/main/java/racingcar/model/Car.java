package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.model.CarConstants.*;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= CAN_MOVE_NUM.getValue()) {
            this.position++;
        }
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_NUM.getValue(), RANDOM_END_NUM.getValue());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
