package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("주어진 횟수 동안 n대의 자동차를 모두 전진시키는 규칙을 적용하면 각 포지션은 1씩 증가함을 테스트하라")
    @Test
    void test1() {
        Cars cars = new Cars(List.of(new Car("A"), new Car("B"), new Car("C")));
        RacingGame game = new RacingGame(cars, () -> true); // 전진시키는 규칙 적용

        List<Integer> positions = game.race();
        List<Integer> positions2 = game.race();
        List<Integer> positions3 = game.race();

        assertThat(positions).isEqualTo(List.of(1, 1, 1));
        assertThat(positions2).isEqualTo(List.of(2, 2, 2));
        assertThat(positions3).isEqualTo(List.of(3, 3, 3));
    }

    @DisplayName("주어진 횟수 동안 n대의 자동차를 모두 정지시키는 규칙을 적용하면 각 포지션은 그래도인 것을 테스트하라")
    @Test
    void test2() {
        Cars cars = new Cars(List.of(new Car("A"), new Car("B"), new Car("C")));
        RacingGame game = new RacingGame(cars, () -> false); // 정지시키는 규칙 적용

        List<Integer> positions = game.race();
        List<Integer> positions2 = game.race();
        List<Integer> positions3 = game.race();

        assertThat(positions).isEqualTo(List.of(0, 0, 0));
        assertThat(positions2).isEqualTo(List.of(0, 0, 0));
        assertThat(positions3).isEqualTo(List.of(0, 0, 0));
    }
}
