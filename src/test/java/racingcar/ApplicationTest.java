package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.context.GameContext;
import racingcar.game.Game;
import racingcar.game.handler.init.GameInitManager;
import racingcar.printer.ResultPrinter;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

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
    void 자동차_이름길이가_5초과일_때_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, spring", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름길이가_0일_때_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_자동차_이름이_입력됐을_때_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hello, hello, pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임이_초기화될_때_게임_문맥데이터_저장_테스트() {

        String input = "pobi,woni,jun\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        Game game = GameInitManager.init();

        Assertions.assertAll(
                () -> {
                    assertThat(GameContext.getAttribute(Game.class)).isEqualTo(game);
                },
                () -> {
                    assertThat(GameContext.getAttribute(ResultPrinter.class)).isNotNull();
                },
                () -> {
                    assertThat(game.getCars()).hasSize(3);
                },
                () -> {
                    assertThat(game.getCars().get(0).getName()).isEqualTo("pobi");
                    assertThat(game.getCars().get(1).getName()).isEqualTo("woni");
                    assertThat(game.getCars().get(2).getName()).isEqualTo("jun");
                },
                () -> {
                    assertThat(game.getRounds()).isEqualTo(3);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
