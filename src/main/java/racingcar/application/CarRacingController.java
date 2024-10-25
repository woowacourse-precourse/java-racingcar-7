package racingcar.application;

import java.util.List;
import racingcar.domain.Racing;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class CarRacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public CarRacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Racing racing = createRacing();
        RacingResult racingResult = racing.play();
        outputView.printRacingResult(racingResult);
    }

    private Racing createRacing() {
        List<String> carNames = inputView.readCarNames();
        RacingCars cars = RacingCars.of(carNames);

        int tryCount = inputView.readTryCount();

        return new Racing(cars, tryCount);
    }
}
