package racingcar.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.MockNumberGenerator;

import java.util.stream.Stream;

class GameRuleTest {
    @ParameterizedTest(name = "{0} <= 4 == {1}")
    @MethodSource("tracingProgressOptions")
    @DisplayName("생성된 숫자가 5보다 작다면 이동 가능")
    void test1(int generatedNumber, boolean expected) {
        MockNumberGenerator generator = new MockNumberGenerator();
        generator.setGeneratedNumber(generatedNumber);
        GameRule rule = new GameRule(generator);

        Assertions.assertEquals(rule.canMove(), expected);
    }

    static Stream<Arguments> tracingProgressOptions() {
        return Stream.of(
                // 단일 페이즈 면접
                Arguments.arguments(0, true),
                Arguments.arguments(1, true),
                Arguments.arguments(4, true),
                Arguments.arguments(5, false),
                Arguments.arguments(9, false)
        );
    }


}