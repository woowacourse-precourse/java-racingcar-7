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

    @Test
    @DisplayName("랜덤값에 따른 정확한 값 출력 - Success Test")
    void collectMovePrintSuccess() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c,d,e,f,g,h,i,j", "1");
                    assertThat(output()).contains("a : ", "b : ", "c : ", "d : ",
                            "e : -", "f : -", "g : -", "h : -", "i : -", "j : -",
                            "최종 우승자 : e, f, g, h, i, j");
                },
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        );
    }

    @Test
    @DisplayName("혼자 우승 - Success Test")
    void singleWinSuccess() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("공동 우승 - Success Test")
    void noneSingleWinSuccess() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("플레이어 이름길이 5이상 입력 - Exception Test")
    void inputPlayerNameLengthOverFive() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("잘못된 횟수 자료형 입력 - Exception Test")
    void inputSequenceNotMatchInteger() {
        assertThatThrownBy(() -> runException("pobi,java", "a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> runException("pobi,java", "3.5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수에 0 or 음수 입력 - Exception Test")
    void inputSequenceNotMatchPlus() {
        assertThatThrownBy(() -> runException("pobi,java", "-1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> runException("pobi,java", "0"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
