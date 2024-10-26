package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.strategy.RandomMoveStrategy;
import racingcar.ui.Input;
import racingcar.domain.CarFactory;
import racingcar.service.RaceManager;
import racingcar.ui.InputParser;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView(new InputParser());
        CarFactory carFactory = new CarFactory(",");
        RaceManager raceManager = new RaceManager(new RandomMoveStrategy());
        ResultView resultView = new ResultView();


        Input input = inputView.getUserInput();

        List<Car> cars = carFactory.getCars(input.getNames());

        String raceResult = raceManager.race(cars, input.getTryCount());
        List<Car> winners = raceManager.getWinners(cars);

        resultView.printRaceResult(raceResult);
        resultView.printWinners(winners);

    }


}
