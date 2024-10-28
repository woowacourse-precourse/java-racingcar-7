package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {
    public RacingGame createGame(List<String> carNames, int rounds){
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        return new RacingGame(cars, rounds);
    }

    public void playGame(RacingGame racingGame){
        racingGame.play();
    }
}
