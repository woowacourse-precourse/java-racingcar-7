package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Game;

public class GameSequenceRepository {
    private Long id = 0L;
    private final Map<Long, Game> gameSequenceMap = new HashMap<>();

    public void save(Game game) {
        id += 1;
        game.setId(++id);
        gameSequenceMap.put(game.getId(), game);
    }

    public Game findById(long id) {
        return gameSequenceMap.get(id);
    }

    public List<Game> findAll() {
        return new ArrayList<>(gameSequenceMap.values());
    }
}
