package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int step;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.step = 0;
    }

    public void go() {
        int random  = Randoms.pickNumberInRange(0, 9);
        if (random >= 4)
            this.step++;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
