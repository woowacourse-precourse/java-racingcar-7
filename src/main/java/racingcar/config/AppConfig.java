package racingcar.config;

import racingcar.app.front.controller.FrontController;
import racingcar.app.server.controller.ServerController;
import racingcar.app.server.service.RaceService;

public class AppConfig {

    private AppConfig() {
    }

    public static class AppConfigHolder {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() {
        return AppConfigHolder.INSTANCE;
    }

    public ServerController initializeServerController() {
        return new ServerController(initializeRaceService());
    }

    private RaceService initializeRaceService() {
        return new RaceService();
    }

    public FrontController initializeFrontController() {
        return new FrontController();
    }
}
