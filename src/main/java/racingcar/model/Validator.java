package racingcar.model;

public class Validator {

    private static final Integer MIN_ROUNDS = 1;
    private static final Integer MAX_ROUNDS = 2147483647;
    private static final String REGEXP_DELIMITER = "^[0-9a-zA-Zㄱ-ㅎ가-힣]+(,[0-9a-zA-Zㄱ-ㅎ가-힣]+)*$";
    private static final String REGEXP_ALPHABET = "^[a-z,]*$";
    private static final String REGEXP_LENGTH = "^[a-z]{1,5}$";

    private static final String WRONG_DELIMITER = "구분자로 쉼표(,)만을 사용하셔야 합니다.";
    private static final String INVALID_CHARACTER = "자동차 이름은 소문자 알파벳으로만 이루어져야 합니다.";
    private static final String LENGTH_EXCEEDED = "자동차 이름은 5자 이하여야 합니다.";
    private static final String MINIMUM_ROUNDS = "시도 횟수는 " + MIN_ROUNDS + "이상이어야 합니다.";
    private static final String MAXIMUM_ROUNDS = "시도 횟수는 " + MAX_ROUNDS + "이하이어야 합니다.";


    public void validateInput(String carName, Integer rounds) {
        validateCarName(carName);
        validateRounds(rounds);
    }

    private void validateCarName(String carName) {
        checkDelimiter(carName);
        checkAlphabet(carName);
        checkNameLength(carName);
    }

    private void checkDelimiter(String carName) {
        if (!carName.matches(REGEXP_DELIMITER)) {
            throw new IllegalArgumentException(WRONG_DELIMITER);
        }
    }

    private void checkAlphabet(String carName) {
        if (!carName.matches(REGEXP_ALPHABET)) {
            throw new IllegalArgumentException(INVALID_CHARACTER);
        }
    }

    private void checkNameLength(String carName) {
        String[] names = carName.split(",");
        for (String splitName : names) {
            if (!splitName.matches(REGEXP_LENGTH)) {
                throw new IllegalArgumentException(LENGTH_EXCEEDED);
            }
        }
    }

    private void validateRounds(Integer rounds) {
        checkMinimumRounds(rounds);
        checkMaximumRounds(rounds);
    }

    private void checkMinimumRounds(Integer rounds) {
        if (rounds < MIN_ROUNDS) {
            throw new IllegalArgumentException(MINIMUM_ROUNDS);
        }
    }

    private void checkMaximumRounds(Integer rounds) {
        if (rounds > MAX_ROUNDS) {
            throw new IllegalArgumentException(MAXIMUM_ROUNDS);
        }
    }
}
