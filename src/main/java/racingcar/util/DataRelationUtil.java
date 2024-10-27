package racingcar.util;

import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.repository.GameRepository;
import racingcar.repository.RoundRepository;

public class DataRelationUtil {

    private static DataRelationUtil instance;

    private GameRepository gameRepository;

    private RoundRepository roundRepository;

    public static DataRelationUtil getInstance() {
        if (instance == null) {
            instance = new DataRelationUtil();
        }
        return instance;
    }

    private DataRelationUtil() {
    }

    public void setRepository(RoundRepository roundRepository, GameRepository gameRepository) {
        this.roundRepository = roundRepository;
        this.gameRepository = gameRepository;
    }

    public void roundToGame(Round round) {
        Game game = gameRepository.findByGameId(round.getGameId());
        if (!game.getRoundList().contains(round) && round.getId() != null) {
            game.addRound(round);
            gameRepository.update(game);
        }
    }

    public void gameToRound(Game game) {
        for (Round round : game.getRoundList()) {
            round.addGameId(game.getId());
            roundRepository.update(round);
        }
    }
}
