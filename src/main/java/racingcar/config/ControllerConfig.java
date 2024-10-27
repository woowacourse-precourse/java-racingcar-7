package racingcar.config;

import racingcar.controller.Controller;
import racingcar.model.Car.move.Forward;
import racingcar.model.Car.move.MoveStrategy;
import racingcar.view.InputView.Input;
import racingcar.view.OutputView.Output;

import static racingcar.config.UtilFactory.getCalculate;
import static racingcar.config.UtilFactory.getStringGenerator;
import static racingcar.config.ValidatorFactory.getCarNameValidator;
import static racingcar.config.ValidatorFactory.getRaceNumValidator;

public class ControllerConfig {
    private static ControllerConfig instance;

    private ControllerConfig() {
    }

    // 싱글톤 인스턴스를 반환하는 메서드
    public static ControllerConfig getInstance() {
        if (instance == null) {
            instance = new ControllerConfig();
        }
        return instance;
    }

    private Input getInput() {
        return new Input(getCarNameValidator(), getRaceNumValidator());
    }

    private Output getOutput(){
        return new Output(getCalculate(), getStringGenerator());
    }

    private MoveStrategy getMoveStrategy (){
        return new Forward();
    }

    public Controller getController() {
        Input input = getInput();
        Output output = getOutput();
        MoveStrategy moveStrategy = getMoveStrategy();
        return new Controller(input, output, moveStrategy);
    }
}
