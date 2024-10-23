package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.RandomNumberGenerator;
import racingcar.service.CarMakerService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new TryCountValidator(), new CarNameValidator());
        CarMakerService carMakerService = new CarMakerService(new CarNameValidator());
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        OutputView outputView = new OutputView(); // 결과 출력 객체

        RacingCarController racingCarController = new RacingCarController(
                inputView, carMakerService, randomNumberGenerator, outputView
        );

        racingCarController.startGame();
    }
}
