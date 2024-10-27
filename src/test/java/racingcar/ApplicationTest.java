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
    void 시도할_횟수가_양수가_아닐_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 값을 입력하였습니다."));
    }

    @Test
    void 자동차_수가_2대_미만일_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("안녕"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 경주는 2대 이상부터 가능합니다."));
    }

    @Test
    void 자동차_이름이_6자_이상일_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("안녕하세요, 안녕하신가요"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 5자 이하만 가능합니다."));
    }

    @Test
    void 중복된_이름이_존재할_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("안, 안, 녕"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 이름이 존재합니다."));
    }

    @Test
    void 특수_문자가_있을_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("안, 녕, !"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 값을 입력하였습니다."));
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
