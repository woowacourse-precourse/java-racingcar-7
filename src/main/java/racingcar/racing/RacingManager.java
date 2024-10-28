package racingcar.racing;

import static racingcar.io.InputUtil.InputString;
import static racingcar.io.OutputUtil.print;
import static racingcar.io.OutputUtil.println;
import static racingcar.message.prompt.ResultPrompt.WINNER_PROMPT;
import static racingcar.message.prompt.UserInputPrompt.CAR_NAME_PROMPT;
import static racingcar.message.prompt.UserInputPrompt.TRY_COUNT_PROMPT;
import static racingcar.util.SplitString.SplitCarNames;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.util.IntConverter;

public class RacingManager {
    private final RaceSimulator raceSimulator = new RaceSimulator();
    private final CarFactory carFactory;

    public RacingManager(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    public void startRacing() {
        List<Car> cars = inputCarName();
        int tryCount = inputTryCount();
        startRaeSimulate(cars, tryCount);
    }

    private List<Car> inputCarName() {
        println(CAR_NAME_PROMPT);
        List<String> carNames = SplitCarNames(InputString());
        return carNames.stream()
                .map(carFactory::createOperation)
                .toList();
    }

    private int inputTryCount() {
        println(TRY_COUNT_PROMPT);
        return IntConverter.StringToInt(InputString());
    }

    private void startRaeSimulate(List<Car> cars, int tryCount) {
        raceSimulator.startRace(cars, tryCount);
        print(WINNER_PROMPT + raceSimulator.getRacingWinner(cars));
    }
}
