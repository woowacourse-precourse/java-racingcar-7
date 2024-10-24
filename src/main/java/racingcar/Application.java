package racingcar;

import racingcar.model.RacingCars;
import racingcar.model.moving_strategy.MovingStrategy;
import racingcar.model.moving_strategy.random.DefaultRandomMovingStrategy;
import racingcar.service.RacingResult;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    private static final MovingStrategy movingStrategy = new DefaultRandomMovingStrategy();
    private final static RacingService racingService = new RacingService(movingStrategy);

    // 필요 변수
    private static RacingCars racingCars;
    private static int tryCount;

    public static void main(String[] args) {
        setUp();
        RacingResult racingResult = playRacing();
        printRacingResult(racingResult);
    }

    // core 함수
    private static void setUp() {
        setUpRacingCars();
        setUpTryCount();
    }

    private static void setUpRacingCars() {
        String carNames = getCarNames();

        List<String> carNameList = getCarNameList(carNames);

        racingCars = createRacingCars(carNameList);
    }

    private static void setUpTryCount() {
        tryCount = getTryCount();
    }

    private static RacingResult playRacing() {
        return racingService.play(racingCars, tryCount);
    }

    private static void printRacingResult(RacingResult racingResult) {
        outputView.printRacingRoundResults(racingResult.roundResults());
        outputView.printWinners(racingResult.winners());
    }

    // helper 함수
    private static RacingCars createRacingCars(List<String> carNameList) {
        return racingService.getRacingCars(carNameList);
    }

    private static List<String> getCarNameList(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    private static String getCarNames() {
        outputView.printInputCarNames();
        return inputView.getCarNames();
    }

    private static int getTryCount() {
        outputView.printInputTryCount();
        return inputView.getTryCount();
    }
}
