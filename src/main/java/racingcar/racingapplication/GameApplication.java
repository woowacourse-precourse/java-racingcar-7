package racingcar.racingapplication;

import java.util.List;
import racingcar.NameSeparator;
import racingcar.Reader;
import racingcar.configuration.AppConfig;
import racingcar.domain.Cars;

public class GameApplication {

    private final NameSeparator nameSeparator;
    private final Reader reader;

    public GameApplication(AppConfig appConfig) {
        this.nameSeparator = appConfig.nameSeparator();
        this.reader = appConfig.reader();
    }

    public void run() {
        String origin = reader.readOrigin();
        List<String> carNames = nameSeparator.separatingNames(origin);
        Cars cars = Cars.makeOriginCars(carNames);
        int gameNumber = reader.readGameNumber();
        runEachGame(cars, gameNumber);
    }

    private Cars runEachGame(Cars cars, int gameNumber) {
        if (gameNumber == 0) {
            return cars;
        }
        Cars carsAfterGame = runEachGame(cars.eachGame(), gameNumber - 1);
        //프린트
        return runEachGame(carsAfterGame, gameNumber - 1);
    }
}
