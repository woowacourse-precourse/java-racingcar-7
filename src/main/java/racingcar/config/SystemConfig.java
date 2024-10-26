package racingcar.config;

import racingcar.client.controller.FrontController;
import racingcar.server.controller.ServerController;
import racingcar.server.service.RaceService;

public class SystemConfig {

    private SystemConfig() {
    }

    public static class AppConfigHolder {
        private static final SystemConfig INSTANCE = new SystemConfig();
    }

    public static SystemConfig getInstance() {
        return AppConfigHolder.INSTANCE;
    }

    public ServerController initializeMainController() {
        return new ServerController(initializeRaceService());
    }

    private RaceService initializeRaceService() {
        return new RaceService();
    }

    public FrontController initializeFrontController() {
        return new FrontController();
    }
}
