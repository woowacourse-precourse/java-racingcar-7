package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("자동차 경주 게임을 실행한다. (4 이상일 때만 전진)")
    void playMove() {
        RacingGame racingGame = new RacingGame(() -> 4);
        Car car1 = new Car("pobi", 0, 4);
        Car car2 = new Car("crong", 0, 4);
        Car car3 = new Car("honux", 0, 4);
        List<Car> cars = List.of(car1, car2, car3);
        
        racingGame.play(cars, 5);

        Assertions.assertThat(car1.getPosition()).isEqualTo(5);
        Assertions.assertThat(car2.getPosition()).isEqualTo(5);
        Assertions.assertThat(car3.getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 경주 게임을 실행한다. (4 이상일 때만 전진)")
    void playNonMove() {
        RacingGame racingGame = new RacingGame(() -> 3);
        Car car1 = new Car("pobi", 0, 4);
        Car car2 = new Car("crong", 0, 4);
        Car car3 = new Car("honux", 0, 4);
        List<Car> cars = List.of(car1, car2, car3);

        racingGame.play(cars, 5);

        Assertions.assertThat(car1.getPosition()).isEqualTo(0);
        Assertions.assertThat(car2.getPosition()).isEqualTo(0);
        Assertions.assertThat(car3.getPosition()).isEqualTo(0);
    }
}