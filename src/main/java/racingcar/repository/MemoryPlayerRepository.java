package racingcar.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.player.Player;

public class MemoryPlayerRepository implements PlayerRepository {
    private final Map<Long, Player> store = new HashMap<>();

    @Override
    public Player save(Player player) {
        store.put(player.getId(), player);
        return player;
    }

    @Override
    public Player findById(Long id) {
        return null;
    }

    @Override
    public List<Player> findAll() {
        return null;
    }

}
