package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.utils.CarNameSplitter;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameSplitterTest {

    @Test
    void 자동차_이름을_쉼표로_구분한다() {
        String input = "pobi,woni,jun,jane";
        List<String> result = CarNameSplitter.separateCarNames(input);

        assertThat(result).hasSize(4);
        assertThat(result).containsExactly("pobi", "woni", "jun", "jane");
    }
}
