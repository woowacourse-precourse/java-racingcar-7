package racingcar.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;

class CarPositionsDisplayTest {

    private CarPositionsDisplay carPositionsDisplay;

    @BeforeEach
    void setUp() {
        carPositionsDisplay = new CarPositionsDisplay();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("자동차들의 위치를 올바른 형식으로 포맷한다.")
    void formatPositions(Cars cars, String expected) {
        cars.moveAll();

        // when
        String result = carPositionsDisplay.formatPositions(cars);

        // then
        assertThat(result.strip()).isEqualTo(expected.strip());
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                // 모두 움직인 케이스
                Arguments.of(
                        new Cars(List.of(
                                new Car("pobi", () -> true),
                                new Car("woni", () -> true),
                                new Car("jun", () -> true)
                        )),
                        """
                        pobi : -
                        woni : -
                        jun : -
                        """
                ),
                // 모두 움직이지 않은 케이스
                Arguments.of(
                        new Cars(List.of(
                                new Car("pobi", () -> false),
                                new Car("woni", () -> false),
                                new Car("jun", () -> false)
                        )),
                        """
                        pobi :\s
                        woni :\s
                        jun :\s
                        """
                ),
                // 어떤 것은 움직이고, 어떤 것은 움직이지 않은 케이스
                Arguments.of(
                        new Cars(List.of(
                                new Car("pobi", () -> true),
                                new Car("woni", () -> false)
                        )),
                        """
                        pobi : -
                        woni :\s
                        """
                )
        );
    }
}
