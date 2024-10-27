package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.util.ErrorMessage;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String CARS = "KIA,HONDA,BMW";


    @Test
    @DisplayName("경주 우승자 단수 테스트")
    void oneWinnerTest() {
        assertRandomNumberInRangeTest(
            () -> {
                run(CARS, "2");
                assertThat(output()).contains("KIA : --", "HONDA : ", "BMW : -", "최종 우승자 : KIA");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    @DisplayName("경주 우승자 복수 테스트")
    void multiWinnerTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(CARS, "2");
                    assertThat(output()).contains("KIA : --", "HONDA : ", "BMW : --", "최종 우승자 : KIA, BMW");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @DisplayName("자동차 이름 5자 이하 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"FERRARI"})
    void carNameLessThanFiveTest(String input) {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.CAR_NAME_LESS_THAN_FIVE.getMessage())
        );
    }

    @DisplayName("자동차 이름 공백 및 빈칸 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    //@NullSource, @EmptySource, @NullOrEmptySource 이거 써야할지도?
    void carNameNotBlankOrEmptyTest(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.CAR_NAME_NOT_BLANK_OR_EMPTY.getMessage())
        );
    }

    @Test
    @DisplayName("경주_단수_우승자_테스트")
    void 자동차_이름_공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CARS + ",,FERRARI", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.CAR_NAME_NOT_BLANK_OR_EMPTY.getMessage())
        );
    }

    @Test
    @DisplayName("경주_단수_우승자_테스트")
    void 자동차_이름_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CARS + ",KIA", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.CAR_NAME_DUPLICATED.getMessage() + "KIA")
        );
    }

    @Test
    @DisplayName("경주_단수_우승자_테스트")
    void 시도_횟수_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CARS, "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.TRY_NUMBER_MORE_THAN_ZERO.getMessage())
        );
    }

    @Test
    @DisplayName("경주_단수_우승자_테스트")
    void 시도_횟수_문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CARS, "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.TRY_NUMBER_NOT_NUMBER.getMessage() + "a")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
