package racingcar.config;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public InputView inputView(){
        return new InputView();
    }

    public OutputView outputView(){
        return new OutputView();
    }

}
