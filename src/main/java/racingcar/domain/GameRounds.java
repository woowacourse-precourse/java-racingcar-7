package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameRounds {
    private final List<Cars> gameRounds;

    public GameRounds() {
        this.gameRounds = new ArrayList<>();
    }

    public void addGameRound(Cars gameRound) {
        Cars copiedCars = new Cars();
        for (Car car : gameRound.getCarList()) {
            copiedCars.addToCarList(new Car(car));
        }
        gameRounds.add(copiedCars);
    }

    public List<Cars> getGameRoundList() {
        return List.copyOf(gameRounds);
    }
}
