package racingcar.model;

import java.util.List;

public class TestableRacingGame extends RacingGame {
    public TestableRacingGame(List<String> carNames, int attempts) {
        super(carNames, attempts);
    }

    @Override
    public void playRound() {
        // 모든 자동차의 위치를 1씩 증가시키도록 설정
        getCars().forEach(car -> car.move(5));
    }
}
