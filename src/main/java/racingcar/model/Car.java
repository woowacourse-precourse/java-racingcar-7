package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validation.Validator;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        Validator.checkNameLength(name);
        Validator.checkNameNull(name);
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
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
