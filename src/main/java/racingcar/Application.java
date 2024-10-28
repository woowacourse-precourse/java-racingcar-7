package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.util.CarNameParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.readCarNames();
        int attempt = InputView.readAttempt();

        CarNameParser parser = new CarNameParser();
        List<Car> cars = parser.parse(carNames);

        OutputView outputView = new OutputView();
        RacingGame game = new RacingGame(cars, attempt, outputView);
        System.out.println("\n실행 결과");
        game.play();


        List<String> winners = game.getWinners();
        outputView.printFinalWinners(winners);

    }
}
