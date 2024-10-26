package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSplitTest {

    @Test
    @DisplayName("문자열이 구분자 , 로 나눠지는 테스트")
    public void testRightSplitString() {
        String input = "po\\bi,won\"i";
        List<String> result = StringSplit.stringSplitBySeparator(input);

        assertIterableEquals(List.of("po\\bi", "won\"i"), result);
    }

    @Test
    @DisplayName("빈 문자열 테스트")
    public void testEmptyString() {
        String input = "";
        List<String> result = StringSplit.stringSplitBySeparator(input);

        assertIterableEquals(List.of(), result);
    }

    @Test
    @DisplayName("빈 문자열이 이름에 포함된 테스트")
    public void testEmptyStringWithSeparator() {
        String input = "a,,b";
        List<String> result = StringSplit.stringSplitBySeparator(input);

        assertIterableEquals(List.of("a", "", "b"), result);
    }

}
