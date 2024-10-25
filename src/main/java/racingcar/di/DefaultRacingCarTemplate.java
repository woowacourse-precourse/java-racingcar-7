package racingcar.di;

import racingcar.model.dependency.validator.DefaultRacingCarValidator;
import racingcar.model.dependency.validator.RacingCarValidator;
import racingcar.service.RacingService;
import racingcar.service.dependency.random_maker.DefaultRandomNumberMaker;
import racingcar.service.dependency.random_maker.RandomNumberMaker;
import racingcar.view.input.DefaultInputView;
import racingcar.view.input.InputView;
import racingcar.view.output.DefaultOutputView;
import racingcar.view.output.OutputView;

public class DefaultRacingCarTemplate implements RacingCarTemplate {

    // View
    private final InputView inputView = new DefaultInputView();
    private final OutputView outputView = new DefaultOutputView();

    // Model
    private final RacingCarValidator racingCarValidator = new DefaultRacingCarValidator();

    // Model - Service
    private final RandomNumberMaker randomNumberMaker = new DefaultRandomNumberMaker();
    private final RacingService racingService = new RacingService(randomNumberMaker, racingCarValidator);

    @Override
    public InputView inputView() {
        return inputView;
    }

    @Override
    public OutputView outputView() {
        return outputView;
    }

    @Override
    public RacingService racingService() {
        return racingService;
    }
}
