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

        game.raceRound();
        game.raceRound();
        game.raceRound();

        Position three = PositionFixture.position(3);
        assertThat(cars.getPositions()).isEqualTo(List.of(three, three, three));
    }

    @DisplayName("주어진 횟수 동안 n대의 자동차를 모두 정지시키는 규칙을 적용하면 각 포지션은 그래도인 것을 테스트하라")
    @Test
    void test2() {
        Cars cars = new Cars(List.of(new Car("A"), new Car("B"), new Car("C")));
        RacingGame game = new RacingGame(cars, () -> false); // 정지시키는 규칙 적용

        game.raceRound();
        game.raceRound();
        game.raceRound();

        Position zero = PositionFixture.position(0);
        assertThat(cars.getPositions()).isEqualTo(List.of(zero, zero, zero));
    }
}
