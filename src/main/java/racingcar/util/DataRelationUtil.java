package racingcar.util;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRepository;
import racingcar.repository.RoundRepository;

public class DataRelationUtil {

    private static DataRelationUtil instance;

    private CarRepository carRepository;

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

    public void setRepository(RoundRepository roundRepository, GameRepository gameRepository, CarRepository carRepository) {
        this.roundRepository = roundRepository;
        this.gameRepository = gameRepository;
        this.carRepository = carRepository;
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

    public void roundToCar(Round round) {
        for(Car car: round.getCarList()) {
            carRepository.update(car);
        }
    }
}
