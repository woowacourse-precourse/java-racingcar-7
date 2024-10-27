package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    //모킹이 작동하지 않고 모두 1으로 들어감
    @Test
    @DisplayName("랜덤 값 테스트 (모킹)")
    void featureTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }
    /*
    //모킹이 작동하지 않고 모두 1으로 들어감
    @Test
    @DisplayName("랜덤 값 테스트 (공동 우승, 실행 결과 예시)")
    void DoubleWinnerTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains(
                            "pobi : -----",
                            "woni : ----",
                            "jun : -----",
                            "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }
     */

    @ParameterizedTest
    @DisplayName("여러 사용자(차) 입력 테스트")
    @ValueSource(strings = {"pobi,woni,jun", "pobi,woni,jun", "pobi,woni,jun,hogun,gamja,be,A"})
    void PlentyCarTest(String names) {
        run(names, "10");
        assertThat(output()).contains("최종 우승자 : ");
    }

    @ParameterizedTest
    @DisplayName("이름 중복 예외처리")
    @ValueSource(strings = {"pobi,woni,pobi", "A,B,C,C", "A,Babo,C,Babo"})
    void InputDuplicatedNameException(String names) {
        assertThatThrownBy(() -> {
            Application.main(new String[]{names, "10"});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("음수 라운드 입력 예외처리")
    @ValueSource(ints = {Integer.MAX_VALUE, -40, -1, 0})
    void InputMinusRoundException(int value) {
        assertThatThrownBy(() -> {
            Application.main(new String[]{"pobi,woni", String.valueOf(value)});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("빈 입력값 예외처리")
    @NullAndEmptySource
    void InputEmptyNameException(String names) {
        assertThatThrownBy(() -> {
            Application.main(new String[]{names, "1"});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("긴 이름 입력 예외처리")
    void InputInvalidNameException() {
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
