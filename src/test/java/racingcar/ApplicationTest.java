package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorType;

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
    @DisplayName("자동차 이름에 빈문자열이 존재하여 예외가 발생한다.")
    void carNameFormatTest() throws Exception {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorType.INVALID_CAR_NAME)
        );
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하여 예외가 발생한다.")
    void carNameLengthTest() throws Exception {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobiiii,gyunnnn", "1"))
                        .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorType.EXCEEDED_MAX_CAR_NAME_LENGTH)
        );
    }

    @Test
    @DisplayName("자동차 이름에 중복이 존재하여 예외가 발생한다.")
    void carNameDuplicateTest() throws Exception {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorType.DUPLICATE_CAR_NAME)
        );
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니므로 예외가 발생한다.")
    void countFormatTest() throws Exception {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,gyun", "a"))
                        .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorType.INVALID_COUNT)
        );
    }

    @Test
    @DisplayName("시도 횟수가 10_000_000 초과하여 예외가 발생한다.")
    void countTest() throws Exception {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,gyun", "100_000_000"))
                        .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorType.EXCEEDED_MAX_COUNT)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
