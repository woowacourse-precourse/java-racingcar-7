package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingCarService;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingCarService = new RacingCarService();
    }

    public void run() {
        List<String> carNameList = getCarNames();
        int tryCount = getTryCount();
        List<Car> carList = racingCarService.initializeCars(carNameList);

        outputView.printResult();
        executeRace(carList, tryCount);
    private void executeRace(List<Car> carList, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingCarService.moveCars(carList);

            printAllCarPosition(carList);
        }
    }

    private void printAllCarPosition(List<Car> carList) {
        for (Car car : carList) {
            outputView.printCarPosition(car.getName(),car.getPosition());
        }
        outputView.printEnter();
    }

    public List<String> getCarNames() {
        outputView.printCarNameInputMessage();
        return InputParser.parseCarNames(inputView.getInput());
    }

    public int getTryCount() {
        outputView.printTryCountInputMessage();
        return InputParser.parseTryCount(inputView.getInput());
    }
}
