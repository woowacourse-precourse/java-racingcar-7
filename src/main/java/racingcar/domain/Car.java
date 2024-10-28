package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int FIRST_POSITION = 0;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final String name;
    private int position = FIRST_POSITION;

    public Car(CarName Carname){
        this.name = Carname.getName();
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= MINIMUM_NUMBER_TO_MOVE) {
            position++;
        }
    }
}