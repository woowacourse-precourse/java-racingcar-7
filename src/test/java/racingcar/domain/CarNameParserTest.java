package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameParserTest {
    @Test
    public void 자동차_이름은_콤마로_구분한다() {
        // given
        List<String> carNames = CarNameParser.parse("pobi,woni,jun");

        // then
        assertThat(carNames).isEqualTo(Arrays.asList("pobi", "woni", "jun"));
    }
}