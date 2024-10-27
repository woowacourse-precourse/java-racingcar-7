package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingTest {
    @MethodSource("testData")
    @ParameterizedTest
    void 레이스_결과(List<Car> input, List<String> output) {
        Racing race = new Racing(input);
        assertThat(race.findWinners()).isEqualTo(output);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments(List.of(new Car("pobi", 2), new Car("yiju", 3)),
                        List.of("yiju")),
                Arguments.arguments(List.of(new Car("pobi", 2), new Car("yiju", 2)),
                        List.of("pobi", "yiju")),
                Arguments.arguments(List.of(new Car("pobi", 3), new Car("yiju", 2)),
                        List.of("pobi"))
        );
    }
}
