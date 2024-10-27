package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarNameSeparatorTest {
    @Test
    void separator_주어진_값을_구분자_기준_구분() {
        String input = "pobi,woni";
        List<String> result = CarNameSeparator.splitCarNameWithSeparator(input);

        assertThat(result).contains("pobi", "woni");
        assertThat(result).containsExactly("pobi", "woni");
    }

    @Test
    void separator_주어진_값의_공백_인식_구분() {
        String input = "pobi, ";
        List<String> result = CarNameSeparator.splitCarNameWithSeparator(input);

        assertThat(result).contains("pobi", " ");
        assertThat(result).containsExactly("pobi", " ");
    }

    @Test
    void separator_주어진_값의_공백_제거해_구분() {
        String input = "pobi, woni ";
        List<String> result = CarNameSeparator.splitCarNameWithoutSpace(input);

        assertThat(result).contains("pobi", "woni");
        assertThat(result).containsExactly("pobi", "woni");
    }

    @Test
    void separator_주어진_값의_공백_인식_제거해_구분() {
        String input = "pobi, ";
        List<String> result = CarNameSeparator.splitCarNameWithoutSpace(input);

        assertThat(result).contains("pobi", "");
        assertThat(result).containsExactly("pobi", "");
    }
}
