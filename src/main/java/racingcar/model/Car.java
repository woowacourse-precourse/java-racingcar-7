package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        return new Car(name, 0);
    }

    public void moveIfPossible() {
        int number = Randoms.pickNumberInRange(0, 9);

        if (number >= 4) {
            this.position += 1;
        }
    }
}
