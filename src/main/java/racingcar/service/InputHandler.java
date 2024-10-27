package racingcar.service;

import racingcar.domain.Car;

import java.util.List;
import java.util.Scanner;
import racingcar.util.Constant;
import racingcar.util.InputUtils;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public List<Car> getCarNames() {
        System.out.println(Constant.CAR_NAME_INPUT_MESSAGE);
        String input = scanner.nextLine();
        return InputUtils.createCarListFromInput(input);
    }

    public int getAttemptCount() {
        System.out.println(Constant.ATTEMPT_INPUT_MESSAGE);
        String input = scanner.nextLine();
        return InputUtils.getAttemptCountFromInput(input);
    }
}
