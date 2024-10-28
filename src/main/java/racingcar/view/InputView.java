package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorStatus;
import racingcar.constant.Separator;
import racingcar.constant.View;

public class InputView {

    private static final String DELIMITER = "|";

    private InputView() {
    }

    private static class InputViewHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewHolder.INSTANCE;
    }

    public List<String> readCarInput() {
        System.out.println(View.CAR_NAME_INPUT.getMessage());
        String input = Console.readLine();
        String regex = getRegexFromSeparator();
        return splitNames(input, regex);
    }

    private List<String> splitNames(String input, String regex) {
        return Arrays.stream(input.split(regex))
                .peek(this::isBlankCarName)
                .toList();
    }

    private String getRegexFromSeparator() {
        return String.join(DELIMITER,
                Arrays.stream(Separator.values())
                        .map(Separator::getSeparator)
                        .toList());
    }

    private void isBlankCarName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_CAR_NAME.getMessage());
        }
    }

    public Integer readCountInput() {
        System.out.println(View.COUNT_INPUT.getMessage());
        String input = Console.readLine();
        isOnlyNumber(input);
        return parseCount(input);
    }

    private void isOnlyNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorStatus.NOT_NUMBER.getMessage());
            }
        }
    }

    private Integer parseCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Overflow
            throw new IllegalArgumentException(ErrorStatus.INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
