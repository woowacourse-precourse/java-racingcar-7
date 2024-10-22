package racingcar.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarParserTest {

    @Test
    void 자동차_이름_배열을_콤마로_연결() {
        // given
        List<Car> winners = List.of(new Car("1"), new Car("2"), new Car("3"));

        // when
        String winnerNames = CarParser.convertCarsToNames(winners);

        // then
        assertThat(winnerNames).isEqualTo("1, 2, 3");
    }
}