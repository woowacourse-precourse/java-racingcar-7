package racingcar.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarNameParserTest {

    @Test
    void 정상_입력() {
        // given
        String input = "pobi,woni,java,rust";
        List<String> expected = Arrays.asList("pobi", "woni", "java", "rust");

        // when
        List<String> actual = CarNameParser.parseCarNames(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void 트림_테스트() {
        // given
        String input = "pobi,  woni , java ,   rust";
        List<String> expected = Arrays.asList("pobi", "woni", "java", "rust");

        // when
        List<String> actual = CarNameParser.parseCarNames(input);

        // then
        assertEquals(expected, actual, "공백 제거를 해야합니다.");
    }

    @Test
    void inputNullTest() {
        // given
        String input = null;

        // when
        assertThrows(IllegalArgumentException.class, () -> CarNameParser.parseCarNames(input),
                "null 입력 시 Exception이 발생해야 합니다.");
    }

    @Test
    void 단일_이름() {
        // given
        String input = "pobi";
        List<String> expected = Collections.singletonList("pobi");

        // when
        List<String> actual = CarNameParser.parseCarNames(input);

        // then
        assertEquals(expected, actual, "단일 이름 입력 시 리스트에 단일 요소가 포함되어야 합니다.");
    }
}
