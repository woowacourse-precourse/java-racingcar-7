package racingcar;

public class RacingCar {
    private final String name;

    public RacingCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        if (name.chars().noneMatch(Character::isLetter)) {
            throw new IllegalArgumentException("이름은 문자만 가능합니다.");
        }
        if (name.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("이름에 숫자가 포함되어있습니다.");
        }

        this.name = name;
    }

    public String name() {
        return name;
    }
}