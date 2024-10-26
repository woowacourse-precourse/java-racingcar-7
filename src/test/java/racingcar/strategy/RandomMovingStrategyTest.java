package racingcar.strategy;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RandomMovingStrategyTest {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int THRESHOLD_NUMBER = 4;
    private RandomMovingStrategy randomMoveStrategy;

    @BeforeEach
    void setUp() {
        randomMoveStrategy = RandomMovingStrategy.getInstance();
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForMoving")
    void THRESHOLD_NUMBER_이상인_경우_이동함을_확인한다(int number) {
        assertRandomNumberInRangeTest(
                () -> assertThat(randomMoveStrategy.shouldMove()).isTrue(),
                number
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForStopping")
    void THRESHOLD_NUMBER_이하인_경우_이동하지_않음을_확인한다(int number) {
        assertRandomNumberInRangeTest(
                () -> assertThat(randomMoveStrategy.shouldMove()).isFalse(),
                number
        );
    }

    Stream<Integer> provideNumbersForMoving() {
        return IntStream.rangeClosed(THRESHOLD_NUMBER, MAX_NUMBER).boxed();
    }

    Stream<Integer> provideNumbersForStopping() {
        return IntStream.rangeClosed(MIN_NUMBER, THRESHOLD_NUMBER - 1).boxed();
    }
}
