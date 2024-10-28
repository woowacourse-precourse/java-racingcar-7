package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars = InputView.inputCars();
        int tryCount = InputView.inputTryCount();

        Race race = new Race(cars, tryCount);
        RaceGame game = new RaceGame(race);
        game.playRacing();
    }
}