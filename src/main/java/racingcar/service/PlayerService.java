package racingcar.service;

import static racingcar.constant.GameConstants.MAXIMUM_PLAYERS;
import static racingcar.constant.GameConstants.MINIMUM_PLAYERS;
import static racingcar.exception.player.PlayerException.PlayerExceededException;
import static racingcar.exception.player.PlayerException.PlayerUnderstaffedException;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.player.Player;
import racingcar.repository.PlayerRepository;
import racingcar.util.IdGenerator;

public class PlayerService {
    private final PlayerRepository repository;
    private final IdGenerator idGenerator;

    public PlayerService(PlayerRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public List<Player> register(List<String> names) {
        validateNames(names);
        return names.stream()
                .map(this::createPlayer)
                .collect(Collectors.toList());
    }

    public List<Player> getAllPlayers() {
        return repository.findAll();
    }

    private void validateNames(List<String> names) {
        if (names.size() > MAXIMUM_PLAYERS) {
            throw new PlayerExceededException();
        }

        if (names.size() < MINIMUM_PLAYERS) {
            throw new PlayerUnderstaffedException();
        }
    }

    private Player createPlayer(String name) {
        Long id = idGenerator.generate();
        Player player = Player.of(id, name);
        return repository.save(player);
    }

}
