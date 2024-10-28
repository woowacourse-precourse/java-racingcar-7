package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
import racingcar.controller.validator.Validator;
import racingcar.controller.validator.ValidatorFactory;
import racingcar.model.Racing;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private final Validator<List<String>> carValidator;
    private final Validator<Integer> roundValidator;
    private final RacingCarView racingCarView;
    private final Supplier<Integer> randomSupplier;
    private Racing racing;
    private Integer round;

    public RacingCarController(RacingCarView racingCarView, ValidatorFactory validatorFactory,
                               Supplier<Integer> randomSupplier) {
        this.carValidator = validatorFactory.getCarValidator();
        this.roundValidator = validatorFactory.getRoundValidator();
        this.racingCarView = racingCarView;
        this.randomSupplier = randomSupplier;
        initialize(racingCarView.inputCarNames(), racingCarView.inputRound());
    }

    public void run() {
        for (int i = 0; i < round; i++) {
            racing.run(randomSupplier);
            racingCarView.printResult(racing.getCars());
        }
        racingCarView.printWinners(racing.findFarthestCars());
    }

    public void initialize(String carNamesInput, String roundInput) {
        List<String> carNames = carValidator.validate(carNamesInput);
        this.round = roundValidator.validate(roundInput);
        this.racing = new Racing(carNames);
    }
}
