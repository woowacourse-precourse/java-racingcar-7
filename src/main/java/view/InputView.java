package view;

import camp.nextstep.edu.missionutils.Console;
import view.domain.InputResult;
import view.message.ErrorMessage;
import view.validation.InputValidator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT = "시도할 횟수는 몇 회인가요?";

    public final InputResult input() throws IllegalArgumentException {
        System.out.println(INPUT_CAR_NAME);
        String cars = Console.readLine();
        InputValidator.validateCars(cars);
        System.out.println(INPUT_COUNT);
        String count = Console.readLine();
        int gameCount = InputValidator.validateCount(count);
        System.out.println();
        Console.close();

        return new InputResult(cars, gameCount);
    }
}
