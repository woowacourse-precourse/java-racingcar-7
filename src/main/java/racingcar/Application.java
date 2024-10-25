package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Cars;
import racingcar.domain.name.Names;
import racingcar.domain.racingGame.RacingGameCount;
import racingcar.service.CarService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService();
        RacingGameService racingGameService = new RacingGameService();

        Names carNames = InputView.inputCarNames();
        Cars cars = carService.generateCars(carNames);

        RacingGameCount count = InputView.inputRaceCount();
        racingGameService.processRacingGame(cars, count);
        Console.close();
    }
}
