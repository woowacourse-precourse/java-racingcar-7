package racingcar.domain;

public class CarName {
    private final String name;
    private final static int NAME_MAX_LENGTH = 5;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열 입력");
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름 길이 초과");
        }
    }

    public String getName() {
        return name;
    }
}
