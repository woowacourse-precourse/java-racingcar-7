package racingcar;

import static racingcar.Constant.MAX_RANDOM;
import static racingcar.Constant.MIN_RANDOM;
import static racingcar.Constant.STANDARD_FOR_MOVING;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;
    Car(String name){
        this.name = name;
    }

    // 자동자 전진함수
    public void moveForward(){
        int movingNum = Randoms.pickNumberInRange(MIN_RANDOM,MAX_RANDOM);
        if (movingNum >= STANDARD_FOR_MOVING){
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
