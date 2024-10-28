package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationExceptionTest extends NsTest {

    @Test
    @DisplayName("최대값 이상으로 실행")
    void test1() {
        String tryout = String.valueOf(Integer.MAX_VALUE);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", tryout))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("음수 입력")
    void test2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("소수 입력")
    void test3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1.2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("콤마 앞 뒤로 문자")
    void test4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("콤마 앞 뒤로 문자2")
    void test5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
