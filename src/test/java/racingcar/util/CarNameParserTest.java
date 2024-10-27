package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.util.CarNameParser;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameParserTest {
    @Test
    public void 자동차_이름은_콤마로_구분한다() {
        // when
        List<String> carNames = CarNameParser.parse("pobi,woni,jun");

        // then
        assertThat(carNames).isEqualTo(Arrays.asList("pobi", "woni", "jun"));
    }
}