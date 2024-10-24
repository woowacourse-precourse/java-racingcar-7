package racingcar.application;

import racingcar.domain.Cars;
import racingcar.domain.MovingStrategy;
import racingcar.domain.RacingGame;
import racingcar.domain.Rounds;

// 서비스는 도메인놈들이 모여서 회의하는 곳. 스트레티지를 의존주입받아서는 안되지 않을까?
public class RacingService {
    private final MovingStrategy movingStrategy;

    public RacingService(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public String getRacingResult(String carNames, String rawCountInput) {
        Cars cars = Cars.of(carNames, movingStrategy);
        Rounds rounds = Rounds.of(rawCountInput);
        RacingGame racingGame = new RacingGame(cars, rounds);
        return racingGame.play();
    }
}
