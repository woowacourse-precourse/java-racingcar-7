package racingcar.model;

public class CarName {
    private static final int MAX_NAME_LENGTH=5;
    private final String name;

    public CarName(String name) {
        validateNotNull(name);
        validateLength(name);
        validateAlphabetOnly(name);
        this.name = name;
    }
    public String getName() {
        return name;
    }
    private void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름이 null이 될 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하로 입력해야 합니다.");
        }
    }

    private void validateAlphabetOnly(String name) {
        if (!name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("자동차 이름은 영어만 가능합니다.");
        }
    }
}
