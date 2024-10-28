package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

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
    void 자동차_이름_5자_이상_입력() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자 이하여야 합니다.")
        );
    }

    @Test
    void 자동차목록_빈문자열_입력() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("아무런 내용이 입력되지 않았습니다."));
    }

    @Test
    void 실행횟수_빈문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", ""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("아무런 내용이 입력되지 않았습니다."));
    }


    @Test
    void 숫자가_아닌_실행횟수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자를 입력해 주세요."));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
