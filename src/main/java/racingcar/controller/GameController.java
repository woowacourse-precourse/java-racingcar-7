package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private GameService gameService;
    private CarService carService;

    public GameController() {
        this.carService = new CarService();
    }

    public void play() {
        List<Car> carList = inputCarNameProcess();
        int playCount = inputCountProcess();

        gameService = new GameService(playCount, carList);
        carsProcess(playCount);
        resultProcess();
    }

    public List<Car> inputCarNameProcess() {
        InputView.inputCarNameView();
        String carNames = Console.readLine();

        return carService.splitCar(carNames);
    }

    public int inputCountProcess() {
        InputView.inputCountView();
        String inputCount = Console.readLine();

        return Integer.parseInt(inputCount);
    }

    public void carsProcess(int count) {
        OutputView.outputProcessResultView();
        for (int i = 0; i < count; i++) {
            OutputView.outputProcessResultListView(gameService.carProcess());
        }
    }

    public void resultProcess() {
        OutputView.outputFinalWinnerView(gameService.determineWinners());
    }
}
