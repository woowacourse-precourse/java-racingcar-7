package racingcar.config;

import racingcar.controller.MainController;
import racingcar.controller.RacingCarController;
import racingcar.controller.RacingCarInputController;
import racingcar.controller.RacingCarOutputController;
import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.util.RandomGenerator;
import racingcar.util.RandomsWrapper;
import racingcar.view.InstructionView;
import racingcar.view.ResultView;
import racingcar.view.RoundView;

public class AppConfig {

    public InstructionView getInstructionView() {
        return new InstructionView();
    }

    public ValidateService getValidateService() {
        return new ValidateService();
    }

    public RacingCarService getRacingCarService() {
        return new RacingCarService();
    }

    public RoundView getRoundView() {
        return new RoundView();
    }

    public ResultView getResultView() {
        return new ResultView();
    }

    public RandomGenerator getRandomGenerator() {
        return new RandomsWrapper();
    }

    public RacingCarInputController getRacingCarInputController() {
        return new RacingCarInputController(getInstructionView());
    }

    public RacingCarController getRacingCarController() {
        return new RacingCarController(getValidateService(), getRacingCarService(), getRandomGenerator());
    }

    public RacingCarOutputController getRacingCarOutputController() {
        return new RacingCarOutputController(getRoundView(), getResultView());
    }

    public MainController getMainController() {
        return new MainController(getRacingCarInputController(), getRacingCarController(), getRacingCarOutputController());
    }

}
