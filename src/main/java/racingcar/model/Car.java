package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validation.Validator;

public class Car {

    private final int RANDOM_NUMBER_START = 0;
    private final int RANDOM_NUMBER_END = 9;
    private final int RANDOM_MOVE_NUMBER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        Validator.checkNameLength(name);
        Validator.checkNameNull(name);
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int number = Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
        if (number >= RANDOM_MOVE_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
