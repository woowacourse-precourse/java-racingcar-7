package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validator.InputValidator;

import java.util.Arrays;

public class InputView {

    private static String COMMA = ",";

    public Cars readCarNames() {
        String input = Console.readLine();
        return new Cars(Arrays.stream(input.split(COMMA))
                .map(Car::new)
                .toList());
    }

    public int readTryCount() {
        String input = Console.readLine();
        InputValidator.validateNumber(input);
        return Integer.parseInt(input);
    }
}
