package racingcar.nameseparator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OriginSeparatorTest {

    @Test
    void separatingNames() {
        //given
        String origin = "sumin,boye";
        OriginSeparator originSeparator = new OriginSeparator();

        //when
        List<String> result = originSeparator.separatingNames(origin);

        //then
        Assertions.assertThat(result).isEqualTo(List.of("sumin", "boye"));
    }
}