package racingcar.domain;

import racingcar.dto.CarStatusDto;
import racingcar.exception.CarNameContainsWhiteSpaceException;
import racingcar.exception.CarNameLengthException;
import racingcar.exception.NonBlankCarNameException;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;
    private static final int NAME_LENGTH_THRESHOLD = 5;
    private static final String WHITE_SPACE = " ";

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    private void validateName(String name) {
        validateNameLength(name);
        validateNonBlankName(name);
        validateNameWithoutWhiteSpace(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_THRESHOLD) {
            throw new CarNameLengthException();
        }
    }

    private void validateNonBlankName(String name) {
        if (name == null || name.isBlank()) {
            throw new NonBlankCarNameException();
        }
    }

    private void validateNameWithoutWhiteSpace(String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new CarNameContainsWhiteSpaceException();
        }
    }

    public int getPosition() {
        return position;
    }

    public CarStatusDto toCarStatusDto() {
        return new CarStatusDto(name, position);
    }
}
