package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.AppConstants;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        InputValidator.checkDelimiter(input);

        List<String> carNames = Arrays.stream(input.split(AppConstants.DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        InputValidator.carNames(carNames);
        return carNames;
    }

    public int getNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        InputValidator.isNumeric(input);

        int attempts = convertToInt(input);
        InputValidator.attemptCount(attempts);
        return attempts;
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    public void close() {
        Console.close();
    }
}