package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.car.Car;
import racingcar.domain.car.Condition;
import racingcar.domain.car.RandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = List.of("car1", "car2", "car3");
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName, new Condition(new RandomNumberGenerator())))
                .toList();
        RacingGame racingGame = new RacingGame(cars, 3);
        while (racingGame.isNotGameOver()) {
            racingGame.playNextRound();
            System.out.println(racingGame.getRacingResult());
        }
        System.out.println(racingGame.getFinalWinners());
    }

}
