package racingcar.domain;

import static racingcar.util.Constant.MAX_RANDOM;
import static racingcar.util.Constant.MIN_RANDOM;
import static racingcar.util.Constant.STANDARD_FOR_MOVING;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;
    public Car(String name){
        this.name = name;
    }

    // 자동자 전진함수
    public void moveForward(){
        if (Randoms.pickNumberInRange(MIN_RANDOM,MAX_RANDOM) >= STANDARD_FOR_MOVING) position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
