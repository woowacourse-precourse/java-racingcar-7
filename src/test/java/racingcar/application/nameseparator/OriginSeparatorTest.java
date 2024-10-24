package racingcar.application.nameseparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class OriginSeparatorTest {

    OriginSeparator originSeparator = new OriginSeparator();

    @Test
    void separateNames() {
        //given
        String notHasExceptionString = "sumin,boye";
        String hasExceptionString = "";
        List<String> expectNames = List.of("sumin", "boye");

        //when
        List<String> names = originSeparator.separateNames(notHasExceptionString);

        //then
        assertThat(names).isEqualTo(expectNames);
        assertThatThrownBy(() -> originSeparator.separateNames(hasExceptionString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}