package racingcar.di;

import racingcar.service.RacingService;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public interface RacingCarTemplate {

    InputView inputView();

    OutputView outputView();

    RacingService racingService();
}
