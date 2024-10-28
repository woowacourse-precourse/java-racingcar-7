package racingcar.model;

import racingcar.constants.RacingGameConstants;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = RacingGameConstants.INITIAL_POSITION.getValue();
    }

    public void advance() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
