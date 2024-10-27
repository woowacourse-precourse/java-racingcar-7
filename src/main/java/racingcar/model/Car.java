package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car extends Vehicle{
    private Car(String name, int position) {
        super(name, position);
    }

    public static Car create (String name) {
        return new Car(name, 0);
    }

}
