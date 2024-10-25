package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ExceptionMessage;

public class Car {

    private static final int RUN_NUMBER = 4;
    private static final String POSITION_MARK = "-";
    private static final String NAME_MARK = " : ";
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            ExceptionMessage message = ExceptionMessage.TOO_LONG_NAME;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= RUN_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getResult() {
        return name + NAME_MARK +
                POSITION_MARK.repeat(position);
    }

    public String getName() {
        return name;
    }
}
