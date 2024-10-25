package racingcar.domain;

import java.util.regex.Pattern;

public class CarName {

    public static final int MAXIMUM = 5;
    public static final Pattern SPECIAL_CHARACTER =Pattern.compile("[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]");
    private final String name;

    public CarName(String name) {
        validateCarsName(name);
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

    private void validateCarsName(String name) {
        if (SPECIAL_CHARACTER.matcher(name).find()) {
            throw new IllegalArgumentException("이름에 특수문자를 포함할 수 없으며, 콤마로 이름을 구분해 주세요.");
        }
    }
}
