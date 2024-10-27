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

    /*
        ### 테스트 시 Application 클래스의 main() 메서드 catch()의 주석을 해제한다. ###
     */

    // 기능 테스트: 올바른 자동차 이름과 시도 횟수
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

    // 예외 테스트 1: 자동차 이름이 5자를 초과
    @Test
    void 자동차이름_길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,abcdefg", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("5자 이하의 이름을 입력해주세요.")
        );
    }

    // 예외 테스트 2: 시도 횟수가 0 이하
    @Test
    void 시도횟수_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("한 라운드 이상 게임을 진행해야 합니다.")
        );
    }

    // 예외 테스트 3: 시도 횟수가 문자
    @Test
    void 시도횟수_문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "IV"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("정수를 입력하세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
