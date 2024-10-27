package racingcar.manager;

import static racingcar.view.InputView.getAttempts;
import static racingcar.view.InputView.getCarNames;
import static racingcar.view.OutputView.printCarPosition;
import static racingcar.view.OutputView.printGameStartMessage;
import static racingcar.view.OutputView.printRacingResultMessage;
import static racingcar.view.OutputView.printRequestAttemptMessage;
import static racingcar.view.OutputView.printWinnerMessage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import racingcar.entity.Car;

public class GameManager {
    private CarManager carManager;

    public GameManager() {
        carManager = new CarManager();
    }

    public List<Car> judgeWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int longest = 0;
        for (Car car : cars) {
            if (car.getPosition() > longest) {
                longest = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == longest) {
                winners.add(car);
            }
        }
        return winners;
    }

    public String getWinnerMessage(List<Car> winners) {
        Iterator<Car> iterator = winners.iterator();
        StringBuilder winnerString = new StringBuilder();

        while (iterator.hasNext()) {
            Car car = iterator.next();
            winnerString.append(car.getCarName());

            if (iterator.hasNext()) {
                winnerString.append(", ");
            }
        }

        return winnerString.toString();
    }

    private void simulate(int attempts, List<Car> carList) {
        for (int i = 0; i < attempts; i++) {
            carManager.moveCars(carList);
            printCarPosition(carList);
        }
    }

    public void gameStart() {
        printGameStartMessage();
        String[] carNames = getCarNames();
        List<Car> carList = carManager.carNamesToCarList(carNames);

        printRequestAttemptMessage();
        int attempts = getAttempts();

        printRacingResultMessage();
        simulate(attempts, carList);

        List<Car> winners = judgeWinner(carList);
        String winnerMessage = getWinnerMessage(winners);
        printWinnerMessage(winnerMessage);
    }
}
