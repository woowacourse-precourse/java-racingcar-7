package racingcar.car.domain;

import static racingcar.global.util.ErrorMessage.INVALID_NAME_FORMAT;

import java.util.regex.Pattern;
import racingcar.car.service.port.RandomHolder;

public class Car {
    private String name;
    private int move;

    public Car(String name) {
        validateNameFormat(name);
        this.name = name;
        this.move = 0;
    }

    public void move(RandomHolder randomHolder) {
        int random = randomHolder.getRandom();
        if (random >= 4) {
            move++;
        }
    }

    private void validateNameFormat(String name) {
        if (!Pattern.matches("^[a-zA-Zㄱ-ㅎ가-힣0-9]{2,8}$", name)) {
            throw new IllegalArgumentException(INVALID_NAME_FORMAT.getMessage());
        }
    }
}
