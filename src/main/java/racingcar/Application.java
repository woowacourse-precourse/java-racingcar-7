package racingcar;

import racingcar.dto.RacingResult;
import racingcar.model.RacingCars;
import racingcar.model.dependency.RacingCarDependency;
import racingcar.model.dependency.moving_strategy.MovingStrategy;
import racingcar.model.dependency.moving_strategy.random.DefaultRandomMovingStrategy;
import racingcar.model.dependency.validator.DefaultRacingCarValidator;
import racingcar.model.dependency.validator.RacingCarValidator;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    private static final RacingCarDependency racingCarDependency = buildRacingCarDependency();
    private final static RacingService racingService = buildRacingService();

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
        List<String> carNameList = getCarNames();

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

    private static List<String> getCarNames() {
        outputView.printInputCarNames();
        return inputView.getCarNames();
    }

    private static int getTryCount() {
        outputView.printInputTryCount();
        return inputView.getTryCount();
    }

    // dependency injection 을 위한 함수
    private static RacingCarDependency buildRacingCarDependency() {
        RacingCarValidator racingCarValidator = new DefaultRacingCarValidator();
        MovingStrategy movingStrategy = new DefaultRandomMovingStrategy();
        return new RacingCarDependency(racingCarValidator, movingStrategy);
    }

    private static RacingService buildRacingService() {
        return new RacingService(racingCarDependency);
    }
}
