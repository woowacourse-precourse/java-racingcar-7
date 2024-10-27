package racingcar.model;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private RacingGame racingGame;

    public void setupGame(List<String> carNames, int rounds) {
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        this.racingGame = new RacingGame(cars, rounds);
    }

    public void playRounds() {
        int rounds = racingGame.getRounds();
        for (int i = 0; i < rounds; i++) {
            racingGame.playRound();
        }
    }

    public List<Car> getCars() {
        return racingGame.getCars();
    }

    public List<Car> getWinners() {
        return racingGame.getWinners();
    }
}
