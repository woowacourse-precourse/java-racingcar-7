package racingcar.model;

import racingcar.constant.ErrorMessage;
import racingcar.constant.Limit;

public class Car {
    public static final int INITIAL_POSITION = 0;
    public static final int MOVEABLE_POWER = 4;
    public static final String COLON = " : ";
    public static final String MOVE_BAR = "-";

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);

        this.name = name;
        this.position = INITIAL_POSITION;
    } // Car

    public void validate(String name) {
        if (name.length() > Limit.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + ErrorMessage.CAR_NAME_MAX_LENGTH_IS_FIVE);
        } // end if
    } // validate

    public void move(int power) {
        if (power >= MOVEABLE_POWER) {
            position++;
        } // end if
    } // move

    public String getRoundResult() {
        return name + COLON + MOVE_BAR.repeat(position);
    } // printPosition
} // class