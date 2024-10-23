package racingcar.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 이름 유효검사
 */
public class Car {
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
        if (name.length() > 6) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하까지 입력 가능합니다.");
        }
    }

    private void validateNameEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("공백으로 입력된 이름이 있습니다.");
        }
    }

    private void validateNameSpecialCharacter(String name) {
        Matcher matcher = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]").matcher(name);
        if (matcher.find()) {
            throw new IllegalArgumentException("자동차 이름에 특수문자는 사용 불가합니다.");
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
