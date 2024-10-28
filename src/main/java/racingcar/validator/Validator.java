package racingcar.validator;

public class Validator {
    private static final String VALID_NAME_PATTERN = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$";
    private static final int NAME_MAX_LENGTH = 5;
    private static final String POSITIVE_INTEGER_PATTERN = "^[0-9]+$";


    private static final String VALIDATE_NAME_PATTERN_MSG = "자동차 이름 입력 형식은 , 단위로 작성해주십시오";
    private static final String MAX_NAME_SIZE_MSG = "이름은 최대 5자까지 가능합니다.";
    private static final String VALIDATE_POSITIVE_INTEGER_MSG = "이동 횟수는 0 이상의 정수만 가능합니다.";

    public void validateAllInput(String inputCarNames, String inputCarRoundCount) {
        validateNameForm(inputCarNames);
        validateNameCount(inputCarNames);
        validateInputCarRoundCount(inputCarRoundCount);
    }


    // 자동차 이름 입력 형식을 검증 (쉼표로 구분), 아니면 throw
    private void validateNameForm(String input) {
        if (!input.matches(VALID_NAME_PATTERN)) {
            throw new IllegalArgumentException(VALIDATE_NAME_PATTERN_MSG);
        }
    }

    // 자동차 이름이 5자 이내인지 검증
    private void validateNameCount(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(MAX_NAME_SIZE_MSG);
            }
        }
    }

    // 이동 횟수 입력을 검증 (양의 정수만 가능.. 음수, 음의 소수, 숫자가 아니거나, 너무 큰 수)
    private void validateInputCarRoundCount(String inputCarRoundCount) {
        if (!inputCarRoundCount.matches(POSITIVE_INTEGER_PATTERN)) {
            throw new IllegalArgumentException(VALIDATE_POSITIVE_INTEGER_MSG);
        }
    }
}
