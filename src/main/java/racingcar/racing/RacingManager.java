package racingcar.racing;

import static racingcar.message.ResultPrompt.WINNER_PROMPT;
import static racingcar.message.UserInputPrompt.CAR_NAME_PROMPT;
import static racingcar.message.UserInputPrompt.TRY_COUNT_PROMPT;
import static racingcar.racing.RaceSimulator.getRacingWinner;
import static racingcar.racing.RaceSimulator.startRace;
import static racingcar.util.SplitString.SplitCarNames;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.io.InputUtil;
import racingcar.io.OutputUtil;
import racingcar.util.IntConverter;

public class RacingManager {
    private final InputUtil inputUtil = InputUtil.getInstance();
    private final OutputUtil outputUtil = OutputUtil.getInstance();
    private final CarFactory carFactory;

    public RacingManager(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    public void startRacing() {
        outputUtil.println(CAR_NAME_PROMPT);
        List<String> carNames = SplitCarNames(inputUtil.InputString());
        List<Car> cars = carNames.stream()
                .map(carFactory::createOperation)
                .toList();

        outputUtil.println(TRY_COUNT_PROMPT);
        long tryCount = IntConverter.StringToInt(inputUtil.InputString());

        startRace(cars, tryCount);
        outputUtil.print(WINNER_PROMPT + getRacingWinner(cars));
    }
}
