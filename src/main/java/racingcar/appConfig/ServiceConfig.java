package racingcar.appConfig;

import racingcar.service.GameService;
import racingcar.service.PlayerService;

public class ServiceConfig {
    private final PlayerService playerService;
    private final GameService gameService;

    public ServiceConfig(DomainConfig domainConfig, RepositoryConfig repositoryConfig) {
        this.playerService = new PlayerService(
                repositoryConfig.getPlayerRepository(),
                repositoryConfig.getIdGenerator()
        );
        this.gameService = new GameService(
                playerService,
                domainConfig.getMovementPolicy()
        );
    }

    public GameService getGameService() {
        return gameService;
    }
}