package view;

import camp.nextstep.edu.missionutils.Console;
import domain.CarName;
import domain.CarNames;
import domain.TryCount;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String OTHER_DELIMITER_REGEX = "[^,\\w\\s가-힣]";
    private static final String DELIMITER_ERROR_MESSAGE = "올바른 구분자를 입력해야 합니다.";


    public static CarNames getCarNames() {
        OutputView.printInputCarNames();
        String input = Console.readLine();
        validateDelimiter(input);
        return new CarNames(Arrays.stream(input.split(DELIMITER)).map(CarName::new).collect(Collectors.toList()));
    }

    public static TryCount getTryCount() {
        OutputView.printInputTryCount();
        String input = Console.readLine();
        return new TryCount(input);
    }

    private static void validateDelimiter(final String input) {
        Pattern pattern = Pattern.compile(OTHER_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException(DELIMITER_ERROR_MESSAGE);
        }
    }
}
