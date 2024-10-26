package racingcar;

import racingcar.config.ApplicationConfiguration;
import racingcar.controller.Controller;
import racingcar.dto.InputDto;
import racingcar.view.RacingView;

public class Application {
    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();

        RacingView racingView = applicationConfiguration.racingView();
        Controller controller = applicationConfiguration.controller();

        InputDto inputDto = racingView.input();
        controller.doRacing(inputDto);
    }
}