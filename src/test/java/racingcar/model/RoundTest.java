package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void Round_생성_테스트(int number) {
        // given &  when
        Round testRound = Round.of(number);
        Round expectedRound = Round.of(number);

        // then
        assertEquals(testRound, expectedRound);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5})
    void Round_예외_음수_테스트(int negativeNum) {
        assertThatThrownBy(() -> Round.of(negativeNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
