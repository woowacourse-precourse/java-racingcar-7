package racingcar.racing.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingRequestParserTest {

    @Test
    void 자동차_이름_파싱() {
        // given
        String carNames = "pobi, woni, java";
        List<String> expectedParsedCarNames = List.of("pobi", "woni", "java");

        // when, then
        Assertions.assertThat(RacingRequestParser.parseCarNames(carNames)).isEqualTo(expectedParsedCarNames);
    }
}
