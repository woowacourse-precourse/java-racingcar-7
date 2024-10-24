/*
 * Car
 *
 * ver1
 *
 * 2024-10-24
 *
 * 저작권 주의
 */
package racingcar.domain;

import racingcar.dto.CarDTO;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int CAR_SPEED = 1;

    private final String carName;
    private int position = 0;

    public Car(String name) {
        validationEmptyName(name);
        validationNameLength(name);
        this.position = 0;
        this.carName = name;
    }

    private void validationEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validationNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public void advance() {
        position += CAR_SPEED;
    }

    public CarDTO getCarDTO() {
        return new CarDTO(carName, position);
    }
}
