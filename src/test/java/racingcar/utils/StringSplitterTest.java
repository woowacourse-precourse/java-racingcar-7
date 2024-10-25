package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSplitterTest {
    @Test
    @DisplayName("주어진 문자열을 주어진 구분자로 나누는지 테스트합니다.")
    void 문자열_나누기_유틸_테스트() {
        String testUserInput = "pobi,woni,jun";

        List<String> result = StringSplitter.splitByDelimiter(testUserInput);
        List<String> answer = new ArrayList<>(List.of("pobi", "woni", "jun"));

        assertThat(result).isEqualTo(answer);
    }
}
