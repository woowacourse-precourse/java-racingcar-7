package racingcar.util;

public class Validator {
    /*
     * CAR_REGEX 정규표현식은 다음과 같은 규칙의 뜻입니다:
     * 1. 이름은 구분자(반점)과 공백을 포함하지 않은 1자리 이상, 5자리 이하의 문자여야 합니다.
     * 2. 오직 하나의 이름이 오는 것도 허용합니다.
     * 3. 이름 사이에는 무조건 구분자(반점)이 있어야 합니다.
     * 4. 구분자 양 옆에는 하나의 공백이 있어도 되고 없어도 됩니다. (반점 사이를 띄어쓰는 입력을 처리하기 위함입니다)
     */

    private static final String CAR_REGEX = "^([^,\\s]{1,5}\\s?,\\s?)*[^,\\s]{1,5}$";
    private static final String ROUND_REGEX = "^[1-9][0-9]*$"; // 라운드 수는 0이거나, 비어있을 수 없다.

    public void checkAboutCars(String input) {
        if (!input.matches(CAR_REGEX)) {
            throw new IllegalArgumentException("경주할 자동차 이름을 잘 못 입력하셨습니다.");
        }
    }

    public void checkAboutRound(String input) {
        if (!input.matches(ROUND_REGEX)) {
            throw new IllegalArgumentException("시도할 횟수는 0이거나 비어있을 수 없습니다.");
        }
    }
}
