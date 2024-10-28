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
    void 시도횟수_0이하입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj","-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 0이상 이어야 합니다")
        );
    }

    @Test
    void 시도횟수_인트최대값초과_예외테스트() {
        String inputOverInteger = String.valueOf(Integer.MAX_VALUE + 1);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji",inputOverInteger))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차량이름입력없음_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("",""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이름 입력이 비어있습니다. 하나 이상의 차 이름을 입력하세요.")
        );
    }

    @Test
    void 차량이름_연속된컴마입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1,,car2", ""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이름에 공백 문자열이 입력되었습니다")
        );
    }

    @Test
    void 차량이름_빈문자열입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1,car2,", ""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이름에 공백 문자열이 입력되었습니다")
        );
    }

    @Test
    void 시도횟수입력없음_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj","",""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도횟수를 입력하세요")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
