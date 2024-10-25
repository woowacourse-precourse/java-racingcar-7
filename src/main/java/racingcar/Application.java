package racingcar;

import java.util.List;
import racingcar.controller.CarRacingController;
import racingcar.view.RacingCarInputView;

public class Application {

    private final CarRacingController carRacingController;

    public Application() {
        this.carRacingController = new CarRacingController();
    }

    public static void main(String[] args) {
        final Application application = new Application();

        application.run();
    }

    private void run() {
        List<String> carNames = RacingCarInputView.inputCarNames();
        int tryCount = RacingCarInputView.inputTryCount();

        carRacingController.race(carNames, tryCount);
    }
}
