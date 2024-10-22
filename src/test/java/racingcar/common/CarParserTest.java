package racingcar.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

class CarParserTest {

    @ParameterizedTest(name = "기대값: {1}")
    @MethodSource(value = "provideCarNames")
    void 자동차_이름_배열을_콤마로_연결(final List<Car> input, final String expected) {
        // when
        String winnerNames = CarParser.convertCarsToNames(input);

        // then
        assertThat(winnerNames).isEqualTo(expected);
    }

    static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of(List.of(new Car("1")), "1"),
                Arguments.of(List.of(new Car("1"), new Car("2")), "1, 2"),
                Arguments.of(List.of(new Car("1"), new Car("2"), new Car("3")), "1, 2, 3")
        );
    }
}