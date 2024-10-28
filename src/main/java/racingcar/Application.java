package racingcar;

import java.util.List;
import model.Car;
import model.CarsHandler;
import model.InputHandler;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        String inputCarNames = inputView.getCarNames();
        String inputMoveCount = inputView.getMoveCount();
        inputView.closeScanner();

        InputHandler inputHandler = new InputHandler();
        String[] carNames = inputHandler.splitCarNames(inputCarNames);
        int moveCount = inputHandler.toInt(inputMoveCount);

        CarsHandler carsHandler = new CarsHandler(carNames);

        OutputView outputView = new OutputView();
        outputView.showRaceStarter();
        for (int i = 0; i < moveCount; i++) {
            carsHandler.moveCars();
            outputView.showRaceStatus(carsHandler.getCars());
        }

        List<Car> winners = carsHandler.getWinners();

        outputView.showWinners(winners);
    }
}
