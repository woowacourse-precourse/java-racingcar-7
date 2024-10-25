package racingcar;

import java.util.List;
import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String nameString = InputView.getCarNames();
        List<String> carNames = InputParser.nameParse(nameString);

        Cars cars = new Cars(carNames);

        String numberString = InputView.getTryNumber();
        int tryNumber = InputParser.tryNumberParse(numberString);

        RacingCarController racingCarController = new RacingCarController();
        String winners = racingCarController.start(cars, tryNumber);

        OutputView.showFinalWinner(winners);
    }
}