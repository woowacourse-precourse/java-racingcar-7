package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Cars;
import racingcar.domain.name.Names;
import racingcar.domain.racingGame.RacingGameCount;
import racingcar.domain.racingGame.RacingRecord;
import racingcar.service.CarService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService();
        RacingGameService racingGameService = new RacingGameService();

        Names carNames = InputView.inputCarNames();
        Cars cars = carService.generateCars(carNames);

        RacingGameCount count = InputView.inputRaceCount();
        List<RacingRecord> records = racingGameService.processRacingGame(cars, count);
        OutputView.printRecords(records);
        OutputView.printWinner(cars.getMaxScoreCarNames());
        Console.close();
    }
}
