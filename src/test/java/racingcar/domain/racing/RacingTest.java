package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

class RacingTest {

    private Cars cars;
    private Racing racing;

    @BeforeEach
    void setUp() {
        cars = Cars.from(List.of("pobi", "woni"));
        racing = Racing.from(1);
    }

    @DisplayName("경주를 생성하면 빈 결과 저장 공간들과 총 라운드 횟수가 지정된다")
    @ValueSource(ints = {1, 100})
    @ParameterizedTest
    void 경주_생성_성공(int roundTotal) {
        assertDoesNotThrow(() -> Racing.from(roundTotal));
    }

    @DisplayName("총 라운드 횟수가 1 미만, 100 초과면 경주가 생성되지 않는다")
    @ValueSource(ints = {0, 101})
    @ParameterizedTest
    void 경주_생성_실패(int roundTotal) {
        assertThatThrownBy(() -> Racing.from(roundTotal))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 경주는 1 이상 100 이하의 라운드만 진행 가능합니다.");
    }

    @DisplayName("자동차들에게 배정된 숫자를 알려줘 경주를 진행한다")
    @Test
    void 경주_진행() {
        List<Integer> numbers = List.of(4, 4);

        racing.play(cars, numbers);

        assertThat(cars.getCars()
                .stream()
                .map(Car::position)
                .map(Position::value)
                .toList()
        ).containsExactly(1, 1);
    }

    @DisplayName("해당 라운드가 끝나면 경주 결과를 저장한다")
    @Test
    void 각_라운드_결과_저장() {
        List<Integer> numbers = List.of(4, 4);
        racing.play(cars, numbers);

        racing.saveRoundResult(cars);

        assertThat(racing.results()
                .getResults()
        ).hasSize(1);
    }

    @DisplayName("모든 라운드가 끝나면 최종 우승자를 발표한다")
    @Test
    void 최종_우승자_발표() {
        List<Integer> numbers = List.of(4, 4);
        racing.play(cars, numbers);
        racing.saveRoundResult(cars);

        assertThat(racing.announceWinners(cars)
                .stream()
                .map(Name::value)
                .toList()
        ).containsExactly("pobi", "woni");
    }

}
