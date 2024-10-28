package racingcar.appConfig;

import racingcar.controller.GameController;

public class AppConfig {
    private final DomainConfig domainConfig;
    private final RepositoryConfig repositoryConfig;
    private final ServiceConfig serviceConfig;
    private final ViewConfig viewConfig;
    private final GameController gameController;

    public AppConfig() {
        this.domainConfig = new DomainConfig();
        this.repositoryConfig = new RepositoryConfig();
        this.serviceConfig = new ServiceConfig(domainConfig, repositoryConfig);
        this.viewConfig = new ViewConfig();
        this.gameController = new GameController(
                serviceConfig.getGameService(),
                viewConfig.getInputView(),
                viewConfig.getOutputView()
        );
    }

    public GameController getGameController() {
        return gameController;
    }
}
