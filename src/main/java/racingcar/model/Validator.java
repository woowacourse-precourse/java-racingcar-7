package racingcar.model;

public class Validator {

    private static final Integer MIN_ROUNDS = 1;
    private static final Integer MAX_ROUNDS = 1000;
    private static final String DELIMITER = ",";
    private static final String REGEXP_DELIMITER = "^[0-9a-zA-Zㄱ-ㅎ가-힣]+(,[0-9a-zA-Zㄱ-ㅎ가-힣]+)*$";
    private static final String REGEXP_ALPHABET = "^[a-z,]*$";
    private static final String REGEXP_LENGTH = "^[a-z]{1,5}$";

    private static final String EMPTY_CAR_NAME = "자동차 이름을 입력하셔야 합니다. 이름은 쉼표(,) 기준으로 구분하여 5자 이하여야 합니다.";
    private static final String SOLO_PLAY = "두 개 이상의 자동차 이름을 입력하셔야 합니다.";
    private static final String WRONG_DELIMITER = "구분자로 쉼표(,)만을 사용하셔야 합니다.";
    private static final String INVALID_CHARACTER = "자동차 이름은 소문자 알파벳으로만 이루어져야 합니다.";
    private static final String LENGTH_EXCEEDED = "자동차 이름은 5자 이하여야 합니다.";

    private static final String EMPTY_ROUNDS =
            "시도 횟수를 입력해주세요. 입력할 수 있는 값은 " + MIN_ROUNDS + "이상 " + MAX_ROUNDS + "이하 입니다.";
    private static final String MINIMUM_ROUNDS = "시도 횟수는 " + MIN_ROUNDS + "이상이어야 합니다.";
    private static final String MAXIMUM_ROUNDS = "시도 횟수는 " + MAX_ROUNDS + "이하이어야 합니다.";


    public void validateInput(String carName, Integer rounds) {
        validateCarName(carName);
        validateRounds(rounds);
    }

    private void validateCarName(String carName) {
        checkEmptyCarName(carName);
        checkSoloPLay(carName);
        checkDelimiter(carName);
        checkAlphabet(carName);
        checkNameLength(carName);
    }

    private void validateRounds(Integer rounds) {
        checkEmptyRounds(rounds);
        checkMinimumRounds(rounds);
        checkMaximumRounds(rounds);
    }

    private static void checkEmptyCarName(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
    }

    private static void checkSoloPLay(String carName) {
        if (!carName.contains(DELIMITER)) {
            throw new IllegalArgumentException(SOLO_PLAY);
        }
    }

    private static void checkDelimiter(String carName) {
        if (!carName.matches(REGEXP_DELIMITER)) {
            throw new IllegalArgumentException(WRONG_DELIMITER);
        }
    }

    private static void checkAlphabet(String carName) {
        if (!carName.matches(REGEXP_ALPHABET)) {
            throw new IllegalArgumentException(INVALID_CHARACTER);
        }
    }

    private static void checkNameLength(String carName) {
        String[] names = carName.split(DELIMITER);
        for (String splitName : names) {
            if (!splitName.matches(REGEXP_LENGTH)) {
                throw new IllegalArgumentException(LENGTH_EXCEEDED);
            }
        }
    }

    private static void checkEmptyRounds(Integer rounds) {
        if (rounds == null) {
            throw new IllegalArgumentException(EMPTY_ROUNDS);
        }
    }

    private static void checkMinimumRounds(Integer rounds) {
        if (rounds < MIN_ROUNDS) {
            throw new IllegalArgumentException(MINIMUM_ROUNDS);
        }
    }

    private static void checkMaximumRounds(Integer rounds) {
        if (rounds > MAX_ROUNDS) {
            throw new IllegalArgumentException(MAXIMUM_ROUNDS);
        }
    }
}
