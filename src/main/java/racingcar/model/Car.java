package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Validator;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
    }


    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random > 4) {
            position++;
        }
    }

    private void validate(String name) {
        Validator.isEmpty(name);
        Validator.isCarNameRange(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
