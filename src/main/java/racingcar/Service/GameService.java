package racingcar.Service;

import racingcar.model.Game;
import racingcar.repository.GameRepository;

public class GameService {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int FORWARD_CONDITION = 4;
    private static final int MIN_VALUE = -1;
    private final GameRepository gameRepository =new GameRepository();


    public Boolean isEnd(Game game) {
        return gameRepository.isEnd(game);
    }

    public Long save(Game game) {
        return gameRepository.save(game);
    }

    


}