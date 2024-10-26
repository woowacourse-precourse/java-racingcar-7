package racingcar.controller;

import java.util.List;
import racingcar.factory.CarFactory;
import racingcar.model.RaceCar;
import racingcar.util.InputUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputUtil inputUtil;
    private final CarFactory carFactory;

    public RacingController(InputView inputView, OutputView outputView, InputUtil inputUtil, CarFactory carFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputUtil = inputUtil;
        this.carFactory = carFactory;
    }

    public void run() {
        List<String> names = inputUtil.convertToList(inputView.getCarNameInput());
        names.forEach(inputUtil::validateCarName);

        int attempts = inputUtil.convertToInt(inputView.getNumberOfAttemptsInput());

        RaceCar raceCar = setRaceCar(names);

        outputView.printExecutionResultHeader();
        while (attempts-- > 0) {
            raceCar.move();
            outputView.printExecutionStatus(raceCar.getCars());
        }
        List<String> winners = raceCar.getWinners();
        outputView.printFinalWinner(winners);

    }

    private RaceCar setRaceCar(List<String> names) {
        return new RaceCar(carFactory.makeCarList(names));
    }
}
