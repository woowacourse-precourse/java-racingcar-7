package racingcar.nameseparator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.application.nameseparator.OriginSeparator;

class OriginSeparatorTest {

    @Test
    void separateNames() {
        //given
        String origin = "sumin,boye";
        OriginSeparator originSeparator = new OriginSeparator();

        //when
        List<String> result = originSeparator.separateNames(origin);

        //then
        Assertions.assertThat(result).isEqualTo(List.of("sumin", "boye"));
    }
}