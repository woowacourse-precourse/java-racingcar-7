package racingcar;

import java.util.List;
import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        Cars cars = new Cars(carNames);
        int tryNumber = InputView.getTryNumber();

        RacingCarController racingCarController = new RacingCarController();
        String winners = racingCarController.start(cars, tryNumber);

        OutputView.showFinalWinner(winners);
    }
}