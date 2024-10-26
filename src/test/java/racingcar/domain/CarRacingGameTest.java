package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingGameTest {
    @Test
    @DisplayName("차량들이 없으면 false를 반환한다.")
    void canNotPlay1() {
        // given
        List<Car> carList = List.of();
        Cars cars = Cars.from(carList);
        CarRacingGame carRacingGame = new CarRacingGame(cars, new RandomNumberGenerator(), 1);
        // then // when
        assertThat(carRacingGame.canPlay()).isFalse();
    }

    @Test
    @DisplayName("게임횟수가 0이면 false를 반환한다.")
    void canNotPlay2() {
        // given
        List<Car> carList = List.of();
        Cars cars = Cars.from(carList);
        CarRacingGame carRacingGame = new CarRacingGame(cars, new RandomNumberGenerator(), 0);
        // then // when
        assertThat(carRacingGame.canPlay()).isFalse();
    }

}