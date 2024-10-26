package racingcar.server.config;

import racingcar.server.controller.MainController;
import racingcar.server.service.RaceService;

public class AppConfig {

    private AppConfig() {
    }

    public static class AppConfigHolder {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() {
        return AppConfigHolder.INSTANCE;
    }

    public MainController initializeMainController() {
        return new MainController(initializeRaceService());
    }

    private RaceService initializeRaceService() {
        return new RaceService();
    }

}
