package racingcar;

import static racingcar.ExceptionMessages.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameService {
    private Game game;

    public Game getGame() {
        return game;
    }

    public void init(Integer round, List<String> carNames) {
        this.game = Game.of(round, createRacingCars(carNames));
    }

    public List<RacingCar> createRacingCars(List<String> carNames) {
        return carNames.stream()
                .map(RacingCar::of)
                .collect(Collectors.toList());
    }

    public List<RacingCar> executeLogic() {
        for (RacingCar racingCar : game.getRacingCars()) {
            Integer randomNumber = GameUtil.getRandomNumber();
            if (GameUtil.isForward(randomNumber)) {
                racingCar.addScore();
            }
        }
        return game.getRacingCars();
    }

    public List<String> selectWinner() {
        Optional<RacingCar> firstWinner = game.getRacingCars().stream().max(Comparator.comparing(RacingCar::getScore));

        if (firstWinner.isEmpty()) {
            throw new IllegalArgumentException(NO_WINNER);
        }

        Integer maxScore = firstWinner.get().getScore();

        return game.getRacingCars().stream()
                .filter(racingCar -> racingCar.getScore().equals(maxScore))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
