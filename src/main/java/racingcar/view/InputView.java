package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.OutputMessage;
import racingcar.service.ValidationService;

public class InputView {
    public List<String> getCarNames() {
        System.out.println(OutputMessage.ENTER_CAR_NAMES.getMessage());
        String input = Console.readLine();

        ValidationService.validateCarNamesInputFormat(input);

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        ValidationService.validateCarNames(carNames);
        return carNames;
    }

    public int getAttempts() {
        System.out.println(OutputMessage.ENTER_ATTEMPTS.getMessage());
        String input = Console.readLine().trim();
        return ValidationService.validateAttempts(input);
    }
}
