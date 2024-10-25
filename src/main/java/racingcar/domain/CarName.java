package racingcar.domain;

public class CarName {

    public static final int MAXIMUM = 5;
    private final String name;

    public CarName(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String name) {
        if (name.isBlank() || name.length() > MAXIMUM) {
            throw new IllegalArgumentException("이름은 1~5자만 가능합니다.");
        }
    }
}
