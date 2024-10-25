package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ErrorMessage;
import racingcar.constant.Limit;
import racingcar.constant.Message;

import java.util.regex.Pattern;

public class InputView {
    public static final String numberPattern = "^[0-9]+$";
    public static final Pattern pattern = Pattern.compile(numberPattern);

    private InputView() {}

    public static String[] responseForCarNames() {
        String input = InputReader.inputMessage();
        String[] inputCarNames = input.split(Message.COMMA);

        if (splitByComma(input)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + ErrorMessage.CAR_NAME_MUST_BE_SPLIT_BY_COMMA);
        } // end if

        for (String carName : inputCarNames) {
            if (carName.length() > Limit.CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.PREFIX + ErrorMessage.CAR_NAME_MAX_LENGTH_IS_FIVE);
            } // end if
        } // end for

        return inputCarNames;
    } // responseForCarNames

    public static boolean splitByComma(String input) {
        return !input.contains(Message.COMMA);
    } // splitByComma

    public static int responseForRaceCount() {
        String inputTimes = Console.readLine();

        if (isNumber(inputTimes)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + ErrorMessage.RACE_COUNT_ONLY_CAN_NUMBER);
        } // end if

        return Integer.parseInt(inputTimes);
    } // responseForRaceCount

    private static boolean isNumber(String inputTimes) {
        return !pattern.matcher(inputTimes).matches();
    } // isNumber
} // class