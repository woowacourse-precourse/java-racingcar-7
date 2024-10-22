package racingcar.racingcar.validator.name;

public class NameValidator {
    public static void withingRangeNameLength(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("[ERROR] 이름 길이가 5초과입니다");
    }
}
