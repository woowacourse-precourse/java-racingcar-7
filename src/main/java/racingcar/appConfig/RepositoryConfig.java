package racingcar.appConfig;

import racingcar.repository.MemoryPlayerRepository;
import racingcar.repository.PlayerRepository;
import racingcar.util.IdGenerator;

public class RepositoryConfig {
    private final PlayerRepository playerRepository;
    private final IdGenerator idGenerator;

    public RepositoryConfig() {
        this.playerRepository = new MemoryPlayerRepository();
        this.idGenerator = new IdGenerator();
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }
}