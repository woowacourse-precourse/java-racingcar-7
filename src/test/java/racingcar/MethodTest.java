package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MethodTest {

    @Test
    @DisplayName("입력이 정상적으로 들어오는지")
    void test_1() {
        String given = "pobi,woni,jun";
        String expected = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(given.getBytes()));
        String result = Application.getInput();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("문자열이 정상적으로 분리 되는지")
    void test_2() {
        String given = "pobi,woni,jun";

        List<String> result = Application.divideMember(given);

        assertThat(result).hasSize(3).containsOnly("pobi", "woni", "jun");
    }
}
