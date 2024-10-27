package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private final Cars cars;
    private final int tryNumber;

    public CarGame(Cars cars, int tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public static CarGame of(Cars cars, int tryNumber) {
        return new CarGame(cars, tryNumber);
    }

    public GameResults play() {
        List<GameResult> gameResults = new ArrayList<>();
        for (int i = 0; i < tryNumber; i++) {
            if (i == 0) {
                gameResults.add(cars.play(GameResult.ofEmpty()));
                continue;
            }
            gameResults.add(cars.play(gameResults.get(i-1)));
        }
        checkLastGame(gameResults);

        return GameResults.of(gameResults);
    }

    private void checkLastGame(List<GameResult> gameResults) {
        gameResults.getLast().checkLastGameResult();
    }

}
