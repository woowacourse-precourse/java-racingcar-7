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
    void 예외_게임횟수_양수인지_확인_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("1 이상의 정수를 입력해주세요.")
        );
    }

    @Test
    void 예외_게임횟수_숫자문자열인지_확인_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자로 변환할 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
