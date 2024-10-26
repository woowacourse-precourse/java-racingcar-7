package racingcar.game;

import racingcar.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGameManager {
    private final List<RacingGameRound> racingGameRounds = new ArrayList<>();

    public void prepareGameRounds(int tryNum, String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName.trim()));
        }

        for (int i = 0; i < tryNum; i++) {
            racingGameRounds.add(new RacingGameRound(carList));
        }
    }

    public void startGame() {
        for (RacingGameRound racingGameRound : racingGameRounds) {
            racingGameRound.racing();
        }
    }
}
