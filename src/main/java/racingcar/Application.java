package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;
import racingcar.controller.RandomSupplier;
import racingcar.controller.validator.ValidatorFactory;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView(Console::readLine, System.out::println);
        ValidatorFactory factory = new ValidatorFactory();
        RandomSupplier supplier = new RandomSupplier(0, 9);
        RacingCarController racingCarController = new RacingCarController(racingCarView, factory, supplier);
        racingCarController.run();
    }
}
