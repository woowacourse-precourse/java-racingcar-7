package racingcar.service;

import racingcar.model.Car;
import racingcar.util.factory.CarFactory;
import racingcar.util.parser.PlayerNameParser;
import racingcar.util.race.RaceExecutor;
import racingcar.util.race.WinnerSelector;
import racingcar.util.validator.PlayerNameValidator;

import java.util.List;

public class CarService {
    private final PlayerNameParser playerNameParser;
    private final PlayerNameValidator playerNameValidator;
    private final WinnerSelector winnerSelector;
    private final RaceExecutor raceExecutor;
    private final CarFactory carFactory;

    public CarService(PlayerNameValidator playerNameValidator,
                      WinnerSelector winnerSelector,
                      PlayerNameParser playerNameParser,
                      RaceExecutor raceExecutor,
                      CarFactory carFactory) {
        this.playerNameValidator = playerNameValidator;
        this.winnerSelector = winnerSelector;
        this.playerNameParser = playerNameParser;
        this.raceExecutor = raceExecutor;
        this.carFactory = carFactory;
    }

    public List<Car> playRounds(String playersName, int moveCount) {
        List<String> names = playerNameParser.splitByComma(playersName);
        playerNameValidator.validateName(names);

        List<Car> cars = carFactory.carGenerator(names);
        raceExecutor.raceStart(cars,moveCount);

        return winnerSelector.getWinners(cars);
    }
}
