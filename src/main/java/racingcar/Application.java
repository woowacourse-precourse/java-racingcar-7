package racingcar;

import racingcar.component.RacingCar;
import racingcar.factory.RacingCarFactory;
import racingcar.race.RacingGame;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String userInput = "red, blue, grey";
        int matchCount = 5;

        RacingCarFactory racingCarFactory = new RacingCarFactory(userInput);
        List<RacingCar> racingCars = racingCarFactory.createRacingCars();

        RacingGame racingGame = new RacingGame(racingCars, matchCount);
        racingGame.play();
        List<RacingCar> winners = racingGame.getWinners();
    }
}
