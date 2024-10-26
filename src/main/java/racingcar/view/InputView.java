package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ErrorMessage;

import java.util.regex.Pattern;

public class InputView {
    public static final String COMMA = ",";
    public static final String CAR_NAME_MUST_BE_SPLIT_BY_COMMA = "자동차 이름은 쉼표(,) 기준으로 구분하여 입력해주세요.";
    public static final String RACE_COUNT_ONLY_CAN_NUMBER = "시도 횟수는 숫자만 입력 가능합니다.";
    public static final String numberPattern = "^[0-9]+$";
    public static final Pattern pattern = Pattern.compile(numberPattern);

    private InputView() {}

    public static String[] responseForCarNames() {
        String input = InputReader.inputMessage();
        String[] inputCarNames = input.split(COMMA);

        if (splitByComma(input)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + CAR_NAME_MUST_BE_SPLIT_BY_COMMA);
        } // end if

        return inputCarNames;
    } // responseForCarNames

    public static boolean splitByComma(String input) {
        return !input.contains(COMMA);
    } // splitByComma

    public static int responseForRaceCount() {
        String inputTimes = Console.readLine();

        if (isNumber(inputTimes)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + RACE_COUNT_ONLY_CAN_NUMBER);
        } // end if

        return Integer.parseInt(inputTimes);
    } // responseForRaceCount

    private static boolean isNumber(String inputTimes) {
        return !pattern.matcher(inputTimes).matches();
    } // isNumber
} // class