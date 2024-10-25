package racingcar;

import java.util.List;
import racingcar.controller.Controller;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.service.Service;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Service service = new Service();

        Controller controller = new Controller(inputView, outputView, service);

        String inputCarNames = controller.inputCarNames();
        int attemptCount = controller.inputAttemptCount();

        List<String> carNames = controller.getCarNames(inputCarNames);
        List<Car> carList = controller.registerCar(carNames);

        Race race = controller.registerRace(carList, attemptCount);
        controller.playGame(race);

        List<Car> winnerCarList = controller.getWinnerCarList(race);
        controller.printWinners(winnerCarList);
    }
}
