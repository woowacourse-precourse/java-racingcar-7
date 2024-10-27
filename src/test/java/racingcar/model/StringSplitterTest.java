package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSplitterTest {

    @Test
    @DisplayName("쉼표(,) 구분자로 문자열을 분할할 수 있다.")
    void splitByComma() {
        // given
        StringSplitter stringSplitter = new StringSplitter();
        String input = "car1,car2,car3";

        // when
        List<String> result = stringSplitter.splitCarNamesToSeparator(input);

        // then
        assertThat(result).containsExactly("car1", "car2", "car3");
    }
}
