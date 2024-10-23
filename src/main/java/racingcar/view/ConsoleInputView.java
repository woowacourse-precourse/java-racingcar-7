package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 콘솔로 입력값을 다루는 클래스
 * 입력값을 받아서 CarController에게 전달한다.
 */
public class ConsoleInputView implements InputView {

    public static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] ";

    public static final String ONLY_DIGIT_ALPHABET_HANGEUL = "[0-9a-zA-Z가-힣]";

    public static final String MAX_CAR_NAME_LENGTH = "5";

    public static final String CAR_NAME_LENGTH_MIN_BETWEEN_MAX =
            "{1," + MAX_CAR_NAME_LENGTH + "}";

    public static final String CAR_NAME_DELIMITER = ",";

    // 자동차 이름 문자열 형식 검증 패턴
    public static final Pattern carNamePattern =
            Pattern.compile("^" +
                    ONLY_DIGIT_ALPHABET_HANGEUL +
                    CAR_NAME_LENGTH_MIN_BETWEEN_MAX +
                    "(" + CAR_NAME_DELIMITER +
                    ONLY_DIGIT_ALPHABET_HANGEUL +
                    CAR_NAME_LENGTH_MIN_BETWEEN_MAX +
                    ")*$");

    /**
     * 콘솔로부터 자동차 이름 문자열을 받아서 형식을 검증한 후 문자열로 반환하는 메서드
     *
     * @return 자동차 이름 문자열(이름 사이에 쉼표(",")가 있는)
     * @throws 자동차 이름이 5글자 초과하거나 이름 중간에 알파벳, 한글, 숫자 이외의 문자가
     *         있으면 IllegalArgumentException 발생
     */
    @Override
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesToValidate = Console.readLine();
        validateNameFormat(carNamesToValidate);
        return carNamesToValidate;
    }

    /**
     * 콘솔로부터 자동차 주행 시도 횟수를 입력받아서 올바른 형식인지 검증한 다음
     * 정수(int)로 반환하는 메서드
     *
     * @return 자동차 주행 시도 횟수
     * @throws 콘솔에서 입력된 문자열이 int 범위를 벗어나거나 숫자가 아닌 문자열이거나
     *         0이면 IllegalArgumentException 발생
     */
    @Override
    public int getChanceToMove() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String chanceInputToValidate = Console.readLine();
        validateNumberFormat(chanceInputToValidate);
        return Integer.parseInt(chanceInputToValidate);
    }

    private void validateNameFormat(String nameToValidate) {
        Matcher matcher = carNamePattern.matcher(nameToValidate);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX
                    + "올바른 자동차 이름 형식이 아닙니다.");
        }
    }

    private void validateNumberFormat(String numberToValidate) {
        validateNotBlank(numberToValidate);
        validateOnlyDigit(numberToValidate);
        validateNotZero(numberToValidate);
    }

    private void validateNotBlank(String numberToValidate) {
        if (numberToValidate.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX
                    + "문자열이 공백입니다. 숫자를 입력하세요.");
        }
    }

    private void validateOnlyDigit(String numberToValidate) {
        try {
            Integer.parseInt(numberToValidate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX
                    + "숫자가 아니거나 int 범위를 벗어납니다.");
        }
    }

    private void validateNotZero(String numberToValidate) {
        int number = Integer.parseInt(numberToValidate);
        if (number == 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX
                    + "시도할 횟수는 양수이어야 합니다.");
        }
    }


}
