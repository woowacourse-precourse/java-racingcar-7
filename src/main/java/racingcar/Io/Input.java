package racingcar.Io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.validation.CarNameValidator;
import racingcar.validation.NumberValidator;

public class Input {
    public static List<Car> carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateCarNames(carNames);
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int attempt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attempt = Console.readLine();
        validateAttempt(attempt);
        System.out.println();
        return Integer.parseInt(attempt);
    }

    private static void validateCarNames(String carNames) {
        CarNameValidator.validateCarNameLength(carNames);
        CarNameValidator.validateCarNameDuplication(carNames);
    }

    private static void validateAttempt(String attempt) {
        NumberValidator.validateIsNumber(attempt);
        NumberValidator.validateIsPositive(attempt);
    }
}
