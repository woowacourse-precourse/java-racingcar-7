package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.model.ModelConstants.*;

public class Car {

    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
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
