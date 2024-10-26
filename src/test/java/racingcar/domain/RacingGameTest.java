package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("차를 전진시키고 시도 횟수를 증가시킨다.")
    void moveCars() {
        // given
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Cars cars = new Cars(List.of(car1, car2));
        RacingGame racingGame = new RacingGame(cars, 1, new TestNumberGenerator());

        // when
        racingGame.moveCars();

        // then
        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
        assertThat(racingGame.isProgress()).isFalse();

    }

    @Test
    @DisplayName("시도 횟수가 남았을 경우 true를 반환한다.")
    void isProgress() {
        // given
        int tryCount = 1;
        Car car = new Car("Car1");
        Cars cars = new Cars(List.of(car));
        RacingGame racingGame = new RacingGame(cars, tryCount, new TestNumberGenerator());

        // when
        boolean progress = racingGame.isProgress();

        // then
        assertThat(progress).isTrue();
    }

    @Test
    @DisplayName("시도 횟수가 남지 않았을 경우 false를 반환한다.")
    void isNotProgress() {
        // given
        int tryCount = 0;
        Car car = new Car("Car1");
        Cars cars = new Cars(List.of(car));
        RacingGame racingGame = new RacingGame(cars, tryCount, new TestNumberGenerator());

        // when
        boolean progress = racingGame.isProgress();

        // then
        assertThat(progress).isFalse();
    }

    class TestNumberGenerator implements NumberGenerator {
        @Override
        public int generateNumber() {
            return 4;
        }
    }
}