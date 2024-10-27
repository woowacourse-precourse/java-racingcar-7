package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingGameTest {

    @Test
    @DisplayName("게임횟수가 0이면 false를 반환한다.")
    void canNotPlay() {
        // given
        List<String> carList = List.of();
        Cars cars = Cars.from(carList);
        CarRacingGame carRacingGame = new CarRacingGame(cars, new RandomNumberGenerator(), 0);
        // then // when
        assertThat(carRacingGame.canPlay()).isFalse();
    }

    @Test
    @DisplayName("자동차 게임 start() 메서드는 게임이 시작된다.")
    void carRacingGameStartTest() {
        // given
        List<String> carList = List.of("pobi", "woni", "jun");
        Cars cars = Cars.from(carList);

        CarRacingGame carRacingGame = new CarRacingGame(cars, new TestNumberGenerator(), 1);
        // when
        List<Car> carlist = carRacingGame.start();

        // then
        assertThat(carlist).hasSize(3);
    }

    static class TestNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 4;
        }
    }
}