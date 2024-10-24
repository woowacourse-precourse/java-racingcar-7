package racingcar;

import racingcar.component.RacingCar;
import racingcar.factory.RacingCarFactory;
import racingcar.race.RacingGame;
import racingcar.race.RacingPlayer;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String userInput = "red, blue, grey";
        int matchCount = 5;

        RacingCarFactory racingCarFactory = new RacingCarFactory(userInput);
        List<RacingPlayer<RacingCar>> racingCars = racingCarFactory.createRacingCars()
                .stream()
                .map((racingCar) -> (RacingPlayer<RacingCar>) racingCar)
                .toList();

        RacingGame<RacingCar> racingGame = new RacingGame<>(racingCars, matchCount);
        racingGame.play();
        List<RacingPlayer<RacingCar>> winners = racingGame.getWinners();
    }
}
