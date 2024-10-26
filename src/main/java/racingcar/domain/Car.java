package racingcar.domain;


import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Constants;
import racingcar.vaildation.Vaild;

public class Car {

    private final String name;

    private int position;

    public Car(String name) {
        Vaild.validateCarName(name);
        this.name = name;
        this.position = 0;
    }

    public void moveTry() {
        if (Randoms.pickNumberInRange(0, 9) >= Constants.MOVE_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
