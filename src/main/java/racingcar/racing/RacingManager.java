package racingcar.racing;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.io.InputUtil;
import racingcar.io.OutputUtil;
import racingcar.message.ResultPrompt;
import racingcar.message.UserInputPrompt;
import racingcar.util.IntConverter;
import racingcar.util.SplitString;

public class RacingManager {
    private final InputUtil inputUtil = InputUtil.getInstance();
    private final OutputUtil outputUtil = OutputUtil.getInstance();
    private final CarFactory carFactory;

    public RacingManager(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    public void startRacing() {
        outputUtil.println(UserInputPrompt.CAR_NAME_PROMPT);
        List<String> carNames = SplitString.SplitCarNames(inputUtil.InputString());
        List<Car> cars = carNames.stream()
                .map(carFactory::createOperation)
                .toList();

        outputUtil.println(UserInputPrompt.TRY_COUNT_PROMPT);
        long tryCount = IntConverter.StringToInt(inputUtil.InputString());

        RaceSimulator.startRace(cars, tryCount);
        outputUtil.print(ResultPrompt.WINNER_PROMPT + RaceSimulator.getRacingWinner(cars));
    }
}
