package racingcar.entity;

import racingcar.enums.DisplaySymbol;
import racingcar.enums.ErrorMessage;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public String getPositionDisplay() {
        return DisplaySymbol.POSITION_SYMBOL.getSymbol().repeat(position);
    }
}
