package racingcar.model;

import racingcar.validator.CarValidator;

public class Car implements Comparable<Car> {
    public static final int INITIAL_POSITION = 0;
    public static final int MOVEABLE_POWER = 4;
    public static final String COLON = " : ";
    public static final String MOVE_BAR = "-";

    private final String name;
    private int position;

    public Car(String name) {
        CarValidator.validateCarName(name);

        this.name = name;
        this.position = INITIAL_POSITION;
    } // Car

    public void move(int power) {
        if (power >= MOVEABLE_POWER) {
            position++;
        } // end if
    } // move

    public String getRoundResult() {
        return name + COLON + MOVE_BAR.repeat(position);
    } // getRoundResult

    public String getName() {
        return name;
    } // getName

    @Override
    public int compareTo(Car compareCar) {
        return Integer.compare(compareCar.position, this.position);
    } // compareTo
} // class