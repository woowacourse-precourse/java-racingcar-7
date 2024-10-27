package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int value;

    public Car(String name) {
        this.name = name;
        value = 0; // default value = 0
    }

    /**
     * @return Car.value
     */
    public int upValue() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            value++;
        }
        return value;
    }
}