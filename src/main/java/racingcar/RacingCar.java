package racingcar;

public class RacingCar {
    private final String name;

    public RacingCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        if (name.codePoints().noneMatch(Character::isLetterOrDigit)) {
            throw new IllegalArgumentException("이름은 문자만 가능합니다.");
        }
        if (name.codePoints().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("이름에 숫자가 포함되어있습니다.");
        }
        if (name.codePoints().anyMatch(Character::isEmoji)) {
            throw new IllegalArgumentException("이름에 문자 외 다른 문자가 존재합니다.");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }
}