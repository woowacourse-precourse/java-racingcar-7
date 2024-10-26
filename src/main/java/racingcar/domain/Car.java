package racingcar.domain;

import static racingcar.constants.Constants;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Constants;

public class Car {

    private final String name;

    private int position;

    public Car(String name) {
        if (name.length() > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Constants.NAME_LENGTH_ERROR);
        }
        this.name = name;
        this.position = 0;
    }

    public void move(){
        if (Randoms.pickNumberInRange(0, 9) >= Constants.MOVE_THRESHOLD) {
            position++;
        }
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

}
