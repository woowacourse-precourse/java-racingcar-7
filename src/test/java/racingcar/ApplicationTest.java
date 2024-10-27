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
    void 우승자가_여려_명일_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : -",
                            "최종 우승자 : pobi, woni, jun");
                },
                4, 4, 4
        );
    }

    // 추가된 테스트 케이스들
    @Test
    void 자동차_이름_길이_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi1234,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 5자 이하여야 합니다.")
        );
    }

    @Test
    void 자동차_이름_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 공백이 될 수 없습니다.")
        );
    }

    @Test
    void 시도횟수_음수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 1 이상이어야 합니다.")
        );
    }

    @Test
    void 시도횟수_숫자아님_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 숫자여야 합니다.")
        );
    }

    @Test
    void 시도횟수_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 숫자여야 합니다.")
        );
    }

    @Test
    void 정상_게임진행_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output())
                            .contains("실행 결과")
                            .contains("pobi : -")
                            .contains("woni : -")
                            .contains("최종 우승자 : ");
                },
                4, 4, 4, 4, 4, 4
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}