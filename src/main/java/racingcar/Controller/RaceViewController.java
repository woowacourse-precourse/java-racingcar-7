package racingcar.Controller;

import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RaceViewController {
    private InputView inputView;
    private OutputView outputView;

        public RaceViewController(InputView inputView, OutputView outputView) {
            this.inputView = inputView;
            this.outputView = outputView;
        }
    }
