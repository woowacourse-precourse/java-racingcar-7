package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int ERROR_NUM = 10;

    @Test
    @DisplayName("정상적인 입력과 진행에 따른 올바른 결과 출력되는지 테스트")
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
    @DisplayName("이름이 숫자로 입력되는 경우 테스트")
    void 이름_숫자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("555,777", "1");
                    assertThat(output()).contains("555 : -", "777 : ", "최종 우승자 : 555");
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
    @DisplayName("첫번째 입력이 공백으로 주어지는 경우 테스트")
    void 첫번째입력_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("두번째 입력이 주어지지 않는 경우 테스트")
    void 두번째입력_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", ""))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("두번째 입력이 공백으로 주어지는 경우 테스트")
    void 두번째입력_공백_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", " "))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("두번째 입력이 숫자가 아닌 경우 테스트")
    void 두번째입력_숫자가_아닌_케이스_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "s"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 전체_경주_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    // 입력값: 자동차 이름과 시도 횟수
                    run("pobi,woni,jun", "5");

                    // 예상 결과 검증
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : -",
                            "pobi : --", "woni : -", "jun : --",
                            "pobi : ---", "woni : --", "jun : ---",
                            "pobi : ----", "woni : ---", "jun : ----",
                            "pobi : -----", "woni : ----", "jun : -----",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 전진숫자가_유효하지않는_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("pobi,woni,jun", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("허용되지 않는 랜덤 숫자 범위입니다.");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, ERROR_NUM, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
