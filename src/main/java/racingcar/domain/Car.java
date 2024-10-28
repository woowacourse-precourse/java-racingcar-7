package racingcar.domain;

import static racingcar.domain.CarConstants.POSITION_SYMBOL;
import static racingcar.domain.GameConstants.MOVED_BOUND;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }


    public void move(int randomNumber) {
        if (randomNumber >= MOVED_BOUND) {
            position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getCurrentStateFormat() {
        String stateFormat = "%s : %s";
        String positionFormat = POSITION_SYMBOL.repeat(position);
        return String.format(stateFormat, name, positionFormat);
    }
}

