package racingcar.model.vo;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Round 테스트")
public class RoundTest {

    @ParameterizedTest()
    @MethodSource("providedForRound")
    void 라운드는_100을_초과하지_않는_양수여야_한다(String round) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Round.fromString(round));
    }

    private static Stream<Arguments> providedForRound() {
        return Stream.of(
            Arguments.of("0"),
            Arguments.of("1회"),
            Arguments.of("101")
        );
    }
}
