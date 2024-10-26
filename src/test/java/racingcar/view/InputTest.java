package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.view.InputView.*;

class InputTest {
    @Test
    @DisplayName("쉼표를 기준으로 문자열 분할")
    void splitDelimiterPositionValid() {
        String input = "pobi,woni,wj";
        List<String> expected = List.of("pobi","woni","wj");
        List<String> result = validateCarNames(input);

        assertEquals(expected, result);
    }
}
