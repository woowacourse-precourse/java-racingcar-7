package racingcar.common;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    @DisplayName("문자를 숫자로 변환한다")
    void testParseToNumeric() {
        assertSimpleTest(() -> {
            long numeric = StringUtil.parseToNumeric("1000");
            assertThat(numeric).isEqualTo(1000L);
        });
    }

    @Test
    @DisplayName("long보다 큰 범위의 숫자는 예외를 던진다")
    void testOverLongType() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        StringUtil.parseToNumeric(String.valueOf((Long.MAX_VALUE + 1))))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("number out of range for type long:")

        );
    }

    @Test
    @DisplayName("콤마 단위로 문자열 배열이분해된다")
    void testSplitByComma() {
        assertSimpleTest(()->{
            List<String> strings = StringUtil.splitByComma("a,b,c");
            assertThat(strings).containsExactly("a", "b", "c");
        });
    }

    @Test
    @DisplayName("콤마로 구분한 문자가 공백인 경우 예외를 던진다")
    void testCheckWhiteSpace() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> StringUtil.splitByComma(" ,1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("name cannot be blank")
        );
    }
}
