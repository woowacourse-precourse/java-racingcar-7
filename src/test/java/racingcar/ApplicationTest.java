package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_5자_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,cdefghi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("cdefghi: 이름은 5자를 초과할 수 없습니다.")
        );
    }

    @Test
    void 중복_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("b: 중복된 이름이 입력되었습니다.")
        );
    }

    @Test
    void 정수가_아닌_값_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "1@@!"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1@@!: 숫자만 입력할 수 있습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
