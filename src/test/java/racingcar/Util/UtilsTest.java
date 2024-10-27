package racingcar.Util;

import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void 차의_이름을_콤마로_구분() {
        String input = "pobi,woni,jun";

        ArrayList<String> carNames = Utils.splitNamesByComma(input);

        Assertions.assertThat(carNames).isEqualTo(Arrays.asList("pobi","woni","jun"));
    }
}
