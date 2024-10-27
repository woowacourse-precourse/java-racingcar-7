package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.util.validator.ListValidator;
import racingcar.util.generator.NumberGenerator;
import racingcar.util.validator.NumberValidator;
import racingcar.util.validator.RacingCarListValidator;
import racingcar.util.validator.RacingCarNumberValidator;
import racingcar.util.validator.RacingCarStringValidator;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.validator.StringValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public NumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public NumberValidator<Integer> racingCarNumberValidator() {
        return new RacingCarNumberValidator();
    }

    public StringValidator racingCarStringValidator() {
        return new RacingCarStringValidator();
    }

    public ListValidator<String> racingCarListValidator() {
        return new RacingCarListValidator();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public RacingCarService racingCarService() {
        return new RacingCarService(
                racingCarListValidator(),
                randomNumberGenerator(),
                racingCarNumberValidator(),
                racingCarStringValidator()
        );
    }

    public RacingCarController racingCarController() {
        return new RacingCarController(
                inputView(),
                outputView(),
                racingCarService()
        );
    }
}
