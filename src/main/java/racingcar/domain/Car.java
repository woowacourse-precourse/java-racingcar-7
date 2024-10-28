package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.Limit;

import java.util.random.RandomGenerator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (isMove()) {
            position += Limit.MOVE_VALUE;
        }
    }

    private boolean isMove() {
        int number = Randoms.pickNumberInRange(Limit.MIN_RANDOM_VALUE, Limit.MAX_RANDOM_VALUE);
        return number >= Limit.MOVE_CRITERIA_VALUE;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

}
