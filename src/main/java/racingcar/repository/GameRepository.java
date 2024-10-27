package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.domain.Game;
import racingcar.util.DataRelationUtil;

public class GameRepository {

    private Integer id = 0;
    private Map<Integer, Game> games = new HashMap<>();
    private static GameRepository instance;
    private DataRelationUtil dataRelationUtil;

    public static GameRepository getInstance() {
        if (instance == null) {
            instance = new GameRepository();
        }

        return instance;
    }

    private GameRepository() {

    }

    public void save(Game game) {
        game.setId(id);
        games.put(id, game);
        dataRelationUtil.gameToRound(game);
        id++;
    }

    public int saveAndReturnId(Game game) {
        Integer currentId = id;
        game.setId(id);
        games.put(id, game);
        if (game.getRoundList() != null) {
            dataRelationUtil.gameToRound(game);
        }
        id++;
        return currentId;
    }

    public void update(Game game) {
        games.replace(game.getId(), game);
        dataRelationUtil.gameToRound(game);
    }

    public Game findByGameId(int id) {
        return games.get(id);
    }

    public void setDataRelationUtil(DataRelationUtil dataRelationUtil) {
        this.dataRelationUtil = dataRelationUtil;
    }
}
