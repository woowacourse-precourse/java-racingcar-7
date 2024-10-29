package racingcar.racing.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingRequestParserTest {

    @Test
    void 자동차_이름_파싱() {
        // given
        String carNames = "pobi, woni, java";
        List<String> expectedParsedCarNames = List.of("pobi", "woni", "java");

        // when, then
        Assertions.assertThat(RacingRequestParser.parseCarNames(carNames)).isEqualTo(expectedParsedCarNames);
    }

    @Test
    void 횟수_파싱() {
        // given
        String round = "5";
        Integer expectedParsedRound = 5;

        // when, then
        Assertions.assertThat(RacingRequestParser.parseRound(round)).isEqualTo(expectedParsedRound);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.5", "asdf", "1.2.3"})
    void 유효하지_않은_횟수_파싱_예외(String round) {
        // given

        // when, then
        Assertions.assertThatThrownBy(() -> RacingRequestParser.parseRound(round))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
