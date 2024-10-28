package racingcar.game;

import racingcar.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGameManager {
    private final int tryNum;
    private final String[] carNames;
    private final WinnerDecider winnerDecider = new WinnerDecider();

    public RacingGameManager(int tryNum, String[] carNames) {
        this.tryNum = tryNum;
        this.carNames = carNames;
    }

    public List<Car> startGame() {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        RacingGameRound racingGameRound = new RacingGameRound(carList);
        for (int i = 0; i < tryNum; i++) {
            racingGameRound.racing();
        }

        return winnerDecider.decideWinner(carList);
    }
}
