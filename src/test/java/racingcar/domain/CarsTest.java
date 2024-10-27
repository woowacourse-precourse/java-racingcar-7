package racingcar.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {
    @ParameterizedTest
    @MethodSource("provideTest")
    void 우승자_구하기(List<Car> testCars, List<String> expected) {
        //given
        final Cars cars = new Cars(testCars);

        //when
        final List<String> winners = cars.getWinners();

        //then
        Assertions.assertThat(winners).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of(List.of(new Car("pobi", 1), new Car("jun", 0)), List.of("pobi")),
                Arguments.of(List.of(new Car("pobi", 0), new Car("jun", 1)), List.of("jun")),
                Arguments.of(List.of(new Car("pobi", 1), new Car("jun", 1)), List.of("pobi", "jun")));
    }
}