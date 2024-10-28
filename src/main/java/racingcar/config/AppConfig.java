package racingcar.config;

import racingcar.Validator;
import racingcar.controller.Racing;
import racingcar.model.RacingManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public InputView inputView(){
        return new InputView();
    }

    public OutputView outputView(){
        return new OutputView();
    }

    public Validator validator(){
        return new Validator();
    }

    public RacingManager racingManager(){
        return new RacingManager();
    }

}
