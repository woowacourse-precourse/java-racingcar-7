package racingcar.domain;

import racingcar.dto.CarStatusDto;

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
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private void validateNonBlankName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름에 빈 문자열은 허용되지 않습니다.");
        }
    }

    private void validateNameWithoutWhiteSpace(String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public CarStatusDto toCarStatusDto() {
        return new CarStatusDto(name, position);
    }
}
