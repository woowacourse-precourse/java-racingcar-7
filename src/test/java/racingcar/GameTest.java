package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @DisplayName("주어진 횟수 동안 n대의 자동차를 모두 전진시키면 각 포지션은 주어진 횟수만큼 증가한다")
    @Test
    void test1() {
        Cars cars = new Cars(List.of(new Car("A"), new Car("B"), new Car("C")));
        Game game = new Game(cars, () -> true);

        List<Integer> positions = game.race();
        List<Integer> positions2 = game.race();
        List<Integer> positions3 = game.race();

        assertThat(positions).isEqualTo(List.of(1, 1, 1));
        assertThat(positions2).isEqualTo(List.of(2, 2, 2));
        assertThat(positions3).isEqualTo(List.of(3, 3, 3));
    }
}
