package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.OutputMessage;
import racingcar.service.ValidationService;

public class InputView {
    public List<String> getCarNames() {
        System.out.println(OutputMessage.ENTER_CAR_NAMES);
        String input = Console.readLine();

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        ValidationService.validateCarNames(carNames);
        return carNames;
    }

    public int getAttempts() {
        System.out.println(OutputMessage.ENTER_ATTEMPTS);
        String input = Console.readLine();
        return ValidationService.validateAttempts(input);
    }
}
