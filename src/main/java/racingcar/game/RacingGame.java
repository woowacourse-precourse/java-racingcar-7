package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.io.InputHandler;
import racingcar.game.io.OutputHandler;
import racingcar.game.model.Car;
import racingcar.game.model.CarGroup;
import racingcar.game.provider.NumberProvider;
import racingcar.game.provider.RandomNumberProvider;
import racingcar.game.util.ParseCarName;

import java.util.*;

import static racingcar.game.constant.ExceptionMessage.INVALID_RACING_COUNT_RANGE;

public class RacingGame {
    private static Integer MAX_RACING_COUNT = 10;
    private static Integer MIN_RACING_COUNT = 1;
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private CarGroup carGroup;
    private NumberProvider numberProvider;

    public RacingGame() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
        this.carGroup = new CarGroup();
        this.numberProvider = new RandomNumberProvider();
    }

    public void run() {
        try {
            String inputCarNames = inputHandler.getCarNames();
            List<String> carNameList = ParseCarName.parse(inputCarNames);

            carGroup.addCars(carNameList);

            Integer racingCount = inputHandler.getRacingCount();
            validateRacingCount(racingCount);

            playRace(racingCount,carGroup);
            List<Car> winners = carGroup.getWinners();

            outputHandler.printWinner(winners);
        } catch (IllegalArgumentException e) {
            outputHandler.printError(e.getMessage());
            throw e;
        }
        Console.close();
    }

    private void playRace(Integer racingCount, CarGroup carGroup) {
        for (int i = 0; i < racingCount; i++) {
            for (Car car : carGroup.getCars()) {
                Integer number = numberProvider.getNumber();
                car.movePosition(number);
                outputHandler.printCarPosition(car);
            }
        }
    }

    public void validateRacingCount(Integer racingCount) {
        if (racingCount < MIN_RACING_COUNT || racingCount > MAX_RACING_COUNT) {
            throw new IllegalArgumentException(INVALID_RACING_COUNT_RANGE.getMessage());
        }
    }
}
