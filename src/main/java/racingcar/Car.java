package racingcar;

public class Car {

    private static final String WHITE_SPACE_REGEX = "\\s+";

    private final String name;

    public Car(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차는 이름을 반드시 가져야 합니다.");
        }
        name = removeWhiteSpace(name);
        validateCarNameLength(name);
        this.name = name;
    }

    private String removeWhiteSpace(String name) {
        return name.replaceAll(WHITE_SPACE_REGEX, "");
    }

    private void validateCarNameLength(String name) {
        int nameLength = name.length();
        if (nameLength == 0 || nameLength > 5) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상, 5글자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
