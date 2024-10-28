package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ExceptionMessage.*;

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

    /**
     * 자동차 이름 입력에 대한 예외 테스트
     */
    @Test
    @DisplayName("자동차 이름 입력 시 2대 이상 입력해야 한다")
    void 자동차_입력_개수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_CAR_COUNT.getValue())
        );
    }

    @ParameterizedTest
    @DisplayName("여러 대의 자동차 이름 입력 시 ,를 기준으로 구분되어야 한다")
    @CsvSource({
            "'pobi,,woni'",
            "'pobi.woni'",
            "'pobi;woni'",
            "'pobi woni'"
    })
    void 자동차_입력_양식_예외_테스트(String carNames) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_CAR_FORMAT.getValue())
        );
    }

    @ParameterizedTest
    @DisplayName("자동차 이름은 1자 이상 5자 이하여야 한다")
    @CsvSource({
            "'pobi,,'",
            "'pobi,woniii'",
    })
    void 자동차_이름_글자수_예외_테스트(String carNames) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_CAR_COUNT.getValue())
        );
    }

    @Test
    @DisplayName("자동차 이름 입력 시 이름들은 중복될 수 없다")
    void 자동차_이름_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_CAR_DUPLICATE.getValue())
        );
    }

    /**
     * 이동 횟수 입력에 대한 예외 테스트
     */
    @ParameterizedTest
    @DisplayName("이동 횟수는 정수여야 한다")
    @CsvSource({
            "1.0",
            "abcd",
            ",:."
    })
    void 이동_횟수_정수가_아닌_경우_테스트(String moveCnt) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", moveCnt))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_COUNT_TYPE.getValue())
        );
    }

    @ParameterizedTest
    @DisplayName("이동 횟수는 1 이상이어야 한다")
    @CsvSource({
            "0",
            "-1"
    })
    void 이동_횟수_범위_예외_테스트(String moveCnt) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", moveCnt))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_COUNT_RANGE.getValue())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
