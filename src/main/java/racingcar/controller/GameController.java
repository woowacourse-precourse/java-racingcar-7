package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.helper.util.InputUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private GameService gameService;
    private CarService carService;

    public GameController() {
        this.carService = new CarService();
    }

    public void play() {
        inputProcess();
        carsProcess();
        resultProcess();
    }

    public void inputProcess() {
        List<Car> carList = inputCarNameProcess();
        int playCount = inputCountProcess();
        gameService = new GameService(playCount, carList);
    }

    public List<Car> inputCarNameProcess() {
        InputView.inputCarNameView();
        String carNames = InputUtil.inputCarNames();
        List<String> carNameList = InputUtil.splitCarNames(carNames);
        return carService.registerCarList(carNameList);
    }

    public int inputCountProcess() {
        InputView.inputCountView();
        return InputUtil.inputCount();
    }

    public void carsProcess() {
        OutputView.outputProcessResultView();
        int count = gameService.getPlayCount();
        for (int i = 0; i < count; i++) {
            OutputView.outputProcessResultListView(gameService.carProcess());
        }
    }

    public void resultProcess() {
        OutputView.outputFinalWinnerView(gameService.determineWinners());
    }
}
