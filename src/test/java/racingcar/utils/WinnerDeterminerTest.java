package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerDeterminerTest {
    @Test
    void 최종_우승자_결정() {
        // given
        List<Car> cars = List.of(
                new Car("pobi", 3),
                new Car("kumar", 2),
                new Car("jun", 4),
                new Car("so", 4)
        );

        // when
        List<String> actual = WinnerDeterminer.determineWinners(cars);
        List<String> expected = List.of("jun", "so");

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
