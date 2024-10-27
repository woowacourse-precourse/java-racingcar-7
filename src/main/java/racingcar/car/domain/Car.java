package racingcar.car.domain;

import static racingcar.global.util.ErrorMessage.INVALID_NAME_FORMAT;

import java.util.regex.Pattern;
import racingcar.car.service.port.RandomHolder;

public class Car implements Comparable<Car> {
    private String name;
    private int move;

    public Car(String name) {
        validateNameFormat(name);
        this.name = name;
        this.move = 0;
    }

    public void move() {
        move++;
    }

    private void validateNameFormat(String name) {
        if (!Pattern.matches("^[a-zA-Zㄱ-ㅎ가-힣0-9]{1,5}$", name)) {
            throw new IllegalArgumentException(INVALID_NAME_FORMAT.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.move, o.move);
    }
}
