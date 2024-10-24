package racingcar.application.nameseparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OriginSeparatorTest {

    OriginSeparator originSeparator = new OriginSeparator();

    @Test
    @DisplayName("문자열을 이름으로 파싱한다.")
    void separateNames() {
        //given
        String notHasExceptionString = "sumin,boye";
        List<String> expectNames = List.of("sumin", "boye");

        //when
        List<String> names = originSeparator.separateNames(notHasExceptionString);

        //then
        assertThat(names).isEqualTo(expectNames);
    }

    @Test
    @DisplayName("빈 문자열을 이름으로 파싱하는 경우 예외가 발생한다.")
    void separateNameHasException() {
        //given
        String hasExceptionString = "";

        //then
        assertThatThrownBy(() -> originSeparator.separateNames(hasExceptionString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}