package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 한_명의_우승자가_나올_수_있다() {
        assertRandomNumberInRangeTest(
                () -> {
                    // Given
                    String cars = "pobi,woni,jun";
                    String tryCount = "5";

                    // When
                    run(cars, tryCount);

                    // Then
                    String result = output().trim();
                    assertThat(result).endsWith("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 여러_명의_우승자가_나올_수_있다() {
        assertRandomNumberInRangeTest(
                () -> {
                    // Given
                    String cars = "pobi,woni,jun";
                    String tryCount = "5";

                    // When
                    run(cars, tryCount);

                    // Then
                    String result = output().trim();
                    assertThat(result).endsWith("최종 우승자 : pobi, woni");
                },
                STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 시도_횟수가_0인_경우_모두_우승자이다() {
        // Given
        String cars = "pobi,woni,jun";
        String tryCount = "0";

        // When
        run(cars, tryCount);

        // Then
        String result = output().trim();
        assertThat(result).endsWith("최종 우승자 : pobi, woni, jun");
    }

    @Test
    void 자동차_이름이_6자_이상인_경우_실패한다() {
        // Given
        String cars = "pobi,javaji";
        String tryCount = "5";

        // When
        ThrowingCallable throwing = () -> runException(cars, tryCount);

        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(throwing)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_입력되지_않은_경우_실패한다() {
        // Given
        String cars = "";
        String tryCount = "3";

        // When
        ThrowingCallable throwing = () -> runException(cars, tryCount);

        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(throwing)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_잘못_입력된_경우_실패한다() {
        // Given
        String cars = "   ,   ";
        String tryCount = "3";

        // When
        ThrowingCallable throwing = () -> runException(cars, tryCount);

        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(throwing)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_비어있는_경우_실패한다() {
        // Given
        String cars = "pobi,woni,jun";
        String tryCount = "";

        // When
        ThrowingCallable throwing = () -> runException(cars, tryCount);

        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(throwing)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_음수인_경우_실패한다() {
        // Given
        String cars = "pobi,woni,jun";
        String tryCount = "-3";

        // When
        ThrowingCallable throwing = () -> runException(cars, tryCount);

        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(throwing)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
