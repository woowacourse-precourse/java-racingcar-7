package domain;

public class CarName {

    private static final String MAXIMUM_NAME_SIZE_ERROR_MESSAGE = "자동차 이름은 5글자 이하로 입력해야 합니다";
    private static final String NAME_EMPTY_ERROR_MESSAGE = "올바른 자동차 이름을 입력해야 합니다.";
    private static final Integer MAXIMUM_NAME_SIZE = 6;

    private String name;

    public CarName(final String name) {
        validateEmpty(name);
        validateNameSize(name);
        this.name = name;
    }

    public void validateNameSize(final String name) {
        if(name.length() >= MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException(MAXIMUM_NAME_SIZE_ERROR_MESSAGE);
        }
    }

    public void validateEmpty(final String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException(NAME_EMPTY_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
