package racingcar.controller;

import racingcar.message.ExceptionCode;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String inputCarNameList = inputView.inputCarNames();

        String[] carNameList = inputCarNameList.split(",");

        int inputTurns = 0;
        try {
            inputTurns = Integer.parseInt(inputView.inputTurnCount());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_TURN.getDescription());
        }
        System.out.println();

        List<Car> carList = new ArrayList<>();
        for (final String name : carNameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(ExceptionCode.CAR_NAME_LENGTH_5.getDescription());
            }

            Car car = new Car(name);
            carList.add(car);
        }

        Racing racing = new Racing(carList);

        for (int i = 0; i < inputTurns; i++) {
            racing.runRacingTurn();
        }

        outputView.printResultMessage();

        for (int i = 1; i <= inputTurns; i++) {
            for (final Car car : carList) {
                outputView.printResult(car.getName(), car.getDistance(i));
            }
            System.out.println();
        }
    }

}
