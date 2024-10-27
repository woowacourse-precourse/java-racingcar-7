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
    void 기능_정상_작동_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "jun : -", "최종 우승자 : pobi,jun");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 이름_미입력자_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,,jun", "1");
                assertThat(output()).contains("pobi : ", "car1 : -", "jun : ", "최종 우승자 : car1");
            },
            STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 입력없음_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아무것도 입력하지 않았습니다. 게임을 진행할 수 없습니다")
        );
    }

    @Test
    void 단독참가_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 2인이 참가해야 대회 진행이 가능합니다 : pobi")
        );
    }

    @Test
    void 시도횟수_문자열_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,jun", "n"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 문자를 입력했거나, 제한된 횟수보다 큰 값을 입력하였습니다 : n")
        );
    }

    @Test
    void int_타입_초과_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,jun", "111111111111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 문자를 입력했거나, 제한된 횟수보다 큰 값을 입력하였습니다 : 111111111111")
        );
    }

    @Test
    void 자연수_미입력_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,jun", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수에는 양수만 입력할 수 있습니다. 입력값 : 0")
        );
    }

    @Test
    void 이름_입력양식_미준수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi!,jun", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각 차의 이름은 숫자와 영어로만 구성되어야 합니다 : pobi!")
        );
    }

    @Test
    void 이름_길이_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobipobi,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("각 차의 이름은 5자를 넘길 수 없습니다 : pobipobi")
        );
    }

    @Test
    void 이름_중복_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,jun,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자들의 차 이름은 모두 다르게 등록되어야 합니다 : pobi")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
