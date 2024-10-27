package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JoinerTest {

    @Test
    void 쉼표로_구분된_문자열을_반환해야한다() {
        // given
        Joiner joiner = new Joiner();

        // when
        String actual = Joiner.join(",", new ArrayList<>(List.of("pobi", "jun", "ken")));

        // then
        assertThat("pobi, jun, ken").isEqualTo(actual);
    }

    @Test
    void 쉼표로_구분되지_않은_문자열을_반환해야한다() {
        // given
        Joiner joiner = new Joiner();

        // when
        String actual = Joiner.join(",", new ArrayList<>(List.of("pobi")));

        // then
        assertThat("pobi").isEqualTo(actual);
    }

}