package racingcar;

import java.util.Objects;

public class RacingCar {
    private final String name;

    public RacingCar(String name) {
        validateLength(name);
        validateNameRule(name);
        this.name = name;
    }

    private static void validateNameRule(String name) {
        // 특수문자 및 숫자 필터링
        if (name.codePoints().anyMatch(c -> (!Character.isLetter(c) && !Character.isWhitespace(c)))) {
            throw new IllegalArgumentException("이름은 문자만 가능합니다.");
        }
        if (name.codePoints().anyMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException("이름은 문자만 가능합니다.");
        }
    }

    private static void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingCar racingCar)) {
            return false;
        }
        return Objects.equals(name, racingCar.name);
    }

    public int hashCode() {
        return Objects.hashCode(name);
    }
}