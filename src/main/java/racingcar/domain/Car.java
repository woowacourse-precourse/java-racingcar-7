package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int RUN_NUMBER = 4;
    private static final String POSITION_MARK = "-";
    private static final String NAME_MARK = " : ";

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= RUN_NUMBER) {
            position++;
        }
    }

    public String getResult() {
        return name + NAME_MARK +
                POSITION_MARK.repeat(position);
    }
}
