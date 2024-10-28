package racingcar.domain;

import static racingcar.domain.ErrorMessage.CAR_NAME_BLANK;
import static racingcar.domain.ErrorMessage.CAR_NAME_CONTAIN_SPECIAL_CHARACTER;
import static racingcar.domain.ErrorMessage.CAR_NAME_MAX;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private final static int MAX_NAME_LENGTH = 5;
    private final String name;
    private int distance = 0;

    public Car(String name) {
        validateNameEmpty(name);
        validateNameLength(name);
        validateNameSpecialCharacter(name);
        this.name = name;
    }

    public void updateDistance(int distance) {
        this.distance += distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }


    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_MAX.getMessage());
        }
    }

    private void validateNameEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK.getMessage());
        }
    }

    private void validateNameSpecialCharacter(String name) {
        Matcher matcher = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(name);
        if (matcher.find()) {
            throw new IllegalArgumentException(CAR_NAME_CONTAIN_SPECIAL_CHARACTER.getMessage());
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
