package racingcar.config;

import racingcar.controller.RacingcarController;
import racingcar.controller.SimpleRacingcarPlayer;
import racingcar.service.RacingcarService;
import racingcar.service.SimpleRacingcarService;
import racingcar.view.RacingcarView;
import racingcar.view.SimpleRacingcarView;

public class AppConfig {

    public static RacingcarController createRacingcarController() {
        return new SimpleRacingcarPlayer(createRacingcarService(), createRacingcarView());
    }

    public static RacingcarView createRacingcarView() {
        return new SimpleRacingcarView();
    }

    public static RacingcarService createRacingcarService() {
        return new SimpleRacingcarService();
    }
}
