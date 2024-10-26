package racingcar.controller;


import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.domain.Racing;
import racingcar.service.RacingService;
import racingcar.utils.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final Racing racing;
    private final CarManager carManager;
    private final OutputView outputView;
    private final RandomNumber randomNumber = new RandomNumber();
    private final RacingService racingService = new RacingService();


    public RacingController(Racing racing, CarManager carManager,
            OutputView outputView) {
        this.racing = racing;
        this.carManager = carManager;
        this.outputView = outputView;
    }

    public void start() {
        racingService.getValidatedStringInput(InputView.getInputCarString());
        racingService.getValidateIntegerInput(InputView.getInputRepeatCount());
        executeRaceRounds();
        announceWinner();
    }

    private void executeRaceRounds() {
        outputView.printGameResultMessage();
        for (int i = 0; i < cnt; i++) {
            runSingleRound();
            outputView.printEmptyLine();
        }
    }

    private void announceWinner() {
        outputView.printWinner(racing.findWinner(carManager.getCars()));
    }

    private void runSingleRound() {
        List<Car> cars = carManager.startRacing(randomNumber);
        for (Car car : cars) {
            outputView.printGameResult(car.getName(), car.getMovedDistance());
        }
    }

}
