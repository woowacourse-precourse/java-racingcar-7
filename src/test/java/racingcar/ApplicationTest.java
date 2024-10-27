package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ExceptionMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.constant.ExceptionMessage.INVALID_NUMBER_FORMAT;
import static racingcar.constant.ExceptionMessage.INVALID_ROUND_MIN;
import static racingcar.constant.ExceptionMessage.NO_CARS;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 정상적으로_경주를_진행한다() {
        // given
        String carNames = "pobi,woni,jun";
        String roundCount = "3";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, roundCount);
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : -",
                            "pobi : --", "woni : -", "jun : --",
                            "pobi : ---", "woni : --", "jun : ---",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,  // 첫 번째 라운드
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,  // 두 번째 라운드
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD   // 세 번째 라운드
        );
    }

    @Test
    void 이름이_하나일때_정상적으로_진행한다() {
        // given
        String carName = "pobi";
        String roundCount = "1";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carName, roundCount);
                    assertThat(output()).contains(
                            "pobi : -",
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 시도_횟수가_0일때_정상적으로_처리한다() {
        // given
        String carNames = "pobi,woni";
        String roundCount = "0";

        // when, then
        assertSimpleTest(() -> {
            run(carNames, roundCount);
            assertThat(output()).contains("최종 우승자 : pobi, woni");
        });
    }

    @Test
    void 공백이_포함된_이름을_정상적으로_처리한다() {
        // given
        String carNames = "pobi , woni , jun";
        String roundCount = "1";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, roundCount);
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : -",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_공백만_입력하면_예외가_발생한다() {
        // given
        String carNames = " ";
        String roundCount = "1";

        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, roundCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NO_CARS.message())
        );
    }

    @Test
    void 이름이_5자를_초과하면_예외가_발생한다() {
        // given
        String carNames = "pobi,longname";
        String roundCount = "1";

        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, roundCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_CAR_NAME_LENGTH.format(1, 5))
        );
    }

    @Test
    void 연속된_쉼표_입력시_실제_이름만_처리한다() {
        // given
        String carNames = "pobi,,jun";
        String roundCount = "1";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, roundCount);
                    assertThat(output()).contains(
                            "pobi : -",
                            "jun : -",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 쉼표로_시작하는_입력을_정상적으로_처리한다() {
        // given
        String carNames = ",pobi,jun";
        String roundCount = "1";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, roundCount);
                    assertThat(output()).contains(
                            "pobi : -",
                            "jun : -",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 쉼표로_끝나는_입력을_정상적으로_처리한다() {
        // given
        String carNames = "pobi,jun,";
        String roundCount = "1";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, roundCount);
                    assertThat(output()).contains(
                            "pobi : -",
                            "jun : -",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 여러_개의_연속된_쉼표를_정상적으로_처리한다() {
        // given
        String carNames = "pobi,,,jun";
        String roundCount = "1";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, roundCount);
                    assertThat(output()).contains(
                            "pobi : -",
                            "jun : -",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 모든_이름이_빈_경우_예외가_발생한다() {
        // given
        String carNames = ",,,";
        String roundCount = "1";

        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, roundCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NO_CARS.message())
        );
    }

    @Test
    void 이름이_공백인_경우만_있으면_예외가_발생한다() {
        // given
        String carNames = " , , ";
        String roundCount = "1";

        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, roundCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NO_CARS.message())
        );
    }

    @Test
    void 실제_이름이_하나만_있을때_정상적으로_처리한다() {
        // given
        String carNames = "pobi,,,,";
        String roundCount = "1";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, roundCount);
                    assertThat(output()).contains(
                            "pobi : -",
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 시도_횟수가_음수이면_예외가_발생한다() {
        // given
        String carNames = "pobi,woni";
        String roundCount = "-1";

        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, roundCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_ROUND_MIN.format(0))
        );
    }

    @Test
    void 시도_횟수가_숫자가_아니면_예외가_발생한다() {
        // given
        String carNames = "pobi,woni";
        String roundCount = "abc";

        // when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, roundCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_NUMBER_FORMAT.message())
        );
    }

    @Test
    void 공동_우승자를_처리한다() {
        // given
        String carNames = "pobi,woni,jun";
        String roundCount = "2";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, roundCount);
                    assertThat(output()).contains(
                            "pobi : -", "woni : -", "jun : -",
                            "pobi : --", "woni : --", "jun : --",
                            "최종 우승자 : pobi, woni, jun"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,  // 첫 번째 라운드
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD   // 두 번째 라운드
        );
    }

    @Test
    void 이름_중복을_정상적으로_처리한다() {
        // given
        String carNames = "pobi,pobi,woni";
        String roundCount = "1";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, roundCount);
                    assertThat(output()).contains(
                            "pobi : -", "pobi : -", "woni : ",
                            "최종 우승자 : pobi, pobi"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 긴_시도_횟수를_정상적으로_처리한다() {
        // given
        String carNames = "pobi,woni";
        String roundCount = "10";

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, roundCount);
                    String result = output();
                    assertThat(result)
                            .contains("pobi : -", "woni : -")
                            .contains("최종 우승자");
                },
                MOVING_FORWARD, MOVING_FORWARD,  // 1라운드
                MOVING_FORWARD, MOVING_FORWARD,  // 2라운드
                MOVING_FORWARD, MOVING_FORWARD,  // 3라운드
                MOVING_FORWARD, MOVING_FORWARD,  // 4라운드
                MOVING_FORWARD, MOVING_FORWARD,  // 5라운드
                MOVING_FORWARD, MOVING_FORWARD,  // 6라운드
                MOVING_FORWARD, MOVING_FORWARD,  // 7라운드
                MOVING_FORWARD, MOVING_FORWARD,  // 8라운드
                MOVING_FORWARD, MOVING_FORWARD,  // 9라운드
                MOVING_FORWARD, MOVING_FORWARD   // 10라운드
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
