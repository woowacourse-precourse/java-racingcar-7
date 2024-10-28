package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import racingcar.domain.player.Player;
import racingcar.exception.player.PlayerException.PlayerNotFoundException;

public class MemoryPlayerRepository implements PlayerRepository {
    private final Map<Long, Player> store = new HashMap<>();

    @Override
    public Player save(Player player) {
        store.put(player.getId(), player);
        return player;
    }

    @Override
    public Player findById(Long id) {
        return Optional.ofNullable(store.get(id))
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @Override
    public List<Player> findAll() {
        return new ArrayList<>(store.values());
    }

}
