package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    private final Cars cars;
    private final Integer gameRound;

    public Game(Cars cars, Integer gameRound) {
        this.cars = cars;
        this.gameRound = gameRound;
    }

    public GameResult playRound() {
        List<Car> carList = this.cars.getCars();
        carList.forEach(car -> {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum > 4) {
                car.raiseMoveCount();  // 자동차 이동 카운트 증가
            }
        });

        return new GameResult(this.cars);
    }

    public Integer getGameRound(){
        return this.gameRound;
    }
}
