package racingcar.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarNameValidator {
    private final static int MAX_LENGTH = 5;
    private final static String DELIM = ",";
    public List<String> validCarNames = new ArrayList<>();

    public List<String> validate(String carNames) {
        validateBlank(carNames);
        validateContainComma(carNames);
        StringTokenizer stringTokenizer = new StringTokenizer(carNames, DELIM);
        while (stringTokenizer.hasMoreTokens()) {
            String name = stringTokenizer.nextToken();
            validateMoreThanFive(carNames);
            validateDuplicate(carNames);
            validCarNames.add(name);
        }
        return validCarNames;
    }

    public void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력은 공백일 수 없습니다.");
        }
    }

    public void validateContainComma(String input) {
        if (!input.contains(DELIM)) {
            throw new IllegalArgumentException("입력에 구분자 ,를 포함해주세요.");
        }
    }

    public void validateDuplicate(String carName) {
        if (validCarNames.contains(carName)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    public void validateMoreThanFive(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름이 5자 이상일 수 없습니다.");
        }
    }

}
