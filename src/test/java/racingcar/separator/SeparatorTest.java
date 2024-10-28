package racingcar.separator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeparatorTest {
    private final String SAMPLE = ",123,456,31n5ang,555555,ee";
    private final String SAMPLE2 = "a b cd e  fg h";

    @Test
    void 문자열_분리_테스트() {
        List<String> separated = Separator.separate(",", SAMPLE);
        assertEquals(6, separated.size());
        assertEquals("", separated.get(0));
        assertEquals("31n5ang", separated.get(3));
    }

    @Test
    void 문자열_분리2_테스트() {
        List<String> separated = Separator.separate(" ", SAMPLE2);
        assertEquals(7, separated.size());
        assertEquals("a", separated.get(0));
        assertEquals("", separated.get(4));
    }
}
