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
    private InputHandler inputHandler = new InputHandler();

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

    @Test
    void 자동차_이름이_빈_문자열인_경우_예외_발생() {
        assertThatThrownBy(() -> inputHandler.makeNameList(new String[]{""}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름에_공백만_있을_경우_예외_발생() {
        assertThatThrownBy(() -> inputHandler.makeNameList(new String[]{"   "}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_횟수가_0일_때_예외_발생() {
        assertThatThrownBy(() -> inputHandler.validateNumberOfGames("0"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_횟수가_음수일_때_예외_발생() {
        assertThatThrownBy(() -> inputHandler.validateNumberOfGames("-1"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_횟수가_숫자가_아닐_때_예외_발생() {
        assertThatThrownBy(() -> inputHandler.validateNumberOfGames("abc"))
            .isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void 라운드별_결과_출력_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "2");
                assertThat(output()).contains("pobi : --", "woni : -");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD  // pobi와 woni 모두 전진
        );
    }

    @Test
    void 종합_기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,crong", "3");
                assertThat(output()).contains("pobi : -", "woni : ---", "crong : --", "최종 우승자 : woni");
            },
            STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }
}
