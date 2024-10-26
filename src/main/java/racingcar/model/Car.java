package racingcar.model;

import racingcar.constant.ErrorMessage;

public class Car implements Comparable<Car> {
    public static final int INITIAL_POSITION = 0;
    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final String CAR_NAME_MAX_LENGTH_IS_FIVE = "자동차 이름은 5자 이하로 입력해주세요.";
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
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + CAR_NAME_MAX_LENGTH_IS_FIVE);
        } // end if
    } // validate

    public void move(int power) {
        if (power >= MOVEABLE_POWER) {
            position++;
        } // end if
    } // move

    public String getRoundResult() {
        return name + COLON + MOVE_BAR.repeat(position);
    } // getRoundResult

    @Override
    public int compareTo(Car compareCar) {
        return Integer.compare(compareCar.position, this.position);
    } // compareTo

    public String getName() {
        return name;
    } // getName
} // class