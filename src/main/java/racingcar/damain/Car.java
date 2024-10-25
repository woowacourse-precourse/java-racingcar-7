package racingcar.damain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void go() {
        if (createRandomNumber()){
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9) > 4;
    }
}
