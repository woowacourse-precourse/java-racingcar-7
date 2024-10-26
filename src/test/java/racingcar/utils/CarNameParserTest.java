package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

public class InputTest {

    @Test
    void 자동차_이름은_쉼표를_기준으로_구분한다() {
        // given
        final String input = "pobi,woni,jun";

        // when
        final List<String> carNames = CarNameParser.parse(input);

        // then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }
}
