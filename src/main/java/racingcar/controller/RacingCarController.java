package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView input;
    private final OutputView output;

    public RacingCarController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        try {
            proceed();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void proceed() {
        String carNames = input.inputCarsName();
        Cars.register(separateName(carNames));
        int tryNumber = Integer.parseInt(input.inputTryNumber());
        move(tryNumber);
        output.printWinner(Cars.findWinner());
    }

    public void move(int tryNumber) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            output.printResult(Cars.moveForward());
        }
    }

    public List<String> separateName(String carNames) {
        return Arrays.asList(carNames.split(","));
    }
}
