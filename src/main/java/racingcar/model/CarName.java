package racingcar.model;

public class CarName {

    public static final int MAX_NAME_LENGTH = 5;

    private static final String NAME_PATTERN = "^[a-zA-Z]+$"; // 알파벳만 허용하며 최대 5자리
    private static final String INVALID_NAME = "자동차 이름은 알파벳으로 이루어져야 하며 5자리 이하여야 합니다.";
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH || !name.matches(NAME_PATTERN)) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
    }
}
