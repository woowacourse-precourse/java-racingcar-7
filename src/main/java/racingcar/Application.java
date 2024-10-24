package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RaceReady;
import racingcar.domain.factory.CarFactory;
import racingcar.service.RaceManager;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        racingcar.domain.factory.CarFactory carFactory = new CarFactory(",");
        RaceManager raceManager = new RaceManager();
        ResultView resultView = new ResultView();

        RaceReady raceReady = inputView.readyForRace();

        List<Car> cars = carFactory.getCars(raceReady.getNameInput());

        for (int i = 0; i < raceReady.getNumberOfTime(); i++) {
            String raceResult = raceManager.race(cars);
            resultView.saveResult(raceResult);
        }

        resultView.printRaceResult();

        List<Car> winners = raceManager.getWinners(cars);

        resultView.printWinners(winners);

    }

}
