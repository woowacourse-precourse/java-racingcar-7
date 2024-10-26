package racingcar;

import racingcar.controller.RacingController;
import racingcar.factory.ValidatorFactory;
import racingcar.factory.ViewFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ViewFactory viewFactory = new ViewFactory();
        ValidatorFactory validatorFactory = new ValidatorFactory();

        RacingController racingController = new RacingController(viewFactory, validatorFactory);

        racingController.run();
    }
}
