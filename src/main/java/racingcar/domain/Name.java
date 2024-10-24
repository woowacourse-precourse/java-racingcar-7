package racingcar.domain;

public class Name {

    private static final String PATTERN = "^[a-z|A-Z]*$";

    private final String name;

    public Name(String name) {
        this.name = validate(name);
    }

    public String getName() {
        return name;
    }

    private static String validate(String name) {
        validateLength(name);
        validateBlank(name);
        validateEnglish(name);

        return name;
    }

    private static void validateEnglish(String name) {
        if (isNotEnglish(name)) {
            throw new IllegalArgumentException("[ERROR]이름은 영문자만 입력 가능합니다.");
        }
    }

    private static boolean isNotEnglish(String name) {
        return !name.matches(PATTERN);
    }

    private static void validateBlank(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("[ERROR]이름은 빈 문자열일 수 없습니다.");
        }
    }

    private static boolean isBlank(String name) {
        return name.isBlank();
    }

    private static void validateLength(String name) {
        if (isOverFive(name)) {
            throw new IllegalArgumentException("[ERROR]이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private static boolean isOverFive(String name) {
        return name.length() > 5;
    }
}
