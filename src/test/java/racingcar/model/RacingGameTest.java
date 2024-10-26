package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.car.MoveStrategy;

class RacingGameTest {

    private Cars cars;
    private AttemptCount attemptCount;
    private RacingGame racingGame;

    public static class FixedMoveStrategy implements MoveStrategy {
        @Override
        public boolean canMove() {
            return true;
        }
    }

    @BeforeEach
    public void setUp() {
        this.cars = new Cars("하나,둘,셋", new FixedMoveStrategy());
        this.attemptCount = AttemptCount.fromString("3");
        this.racingGame = new RacingGame(this.cars, this.attemptCount);
    }

    @Test
    void 레이싱게임_정상_실행() {
        // given
        // when
        racingGame.play();

        // then
        List<List<CarSnapshot>> roundResults = racingGame.getRoundResults();

        for (List<CarSnapshot> roundResult : roundResults) {
            assertThat(roundResult).hasSize(3); // 각 라운드에 자동차 3대
            for (CarSnapshot carSnapshot : roundResult) {
                assertThat(carSnapshot.carName()).isIn("하나", "둘", "셋");
                assertThat(carSnapshot.position()).isPositive();
            }
        }

        assertThat(roundResults).hasSize(3); // 전체 라운드 개수가 3회와 일치하는지 확인
    }


}
