package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @DisplayName("주어진 횟수 동안 n대의 자동차를 모두 전진시키면 각 포지션은 주어진 횟수만큼 증가한다")
    @Test
    void test1() {
        Car a = new Car("A");
        Car b = new Car("B");
        Car c = new Car("C");
        Cars cars = new Cars(List.of(a, b, c));
        Game game = new Game(cars, 3);

        game.race();

        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars()).contains(a, b, c);
        assertThat(a.getPosition()).isEqualTo(3);
        assertThat(b.getPosition()).isEqualTo(3);
        assertThat(c.getPosition()).isEqualTo(3);
    }
}
