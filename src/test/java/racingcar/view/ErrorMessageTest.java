package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.constants.ErrorType;

import static org.assertj.core.api.Assertions.*;


class ErrorMessageTest extends NsTest {

    @Test
    @DisplayName("공백, 개행문자, tab 와같은 빈 문자열 입력시 예외 처리")
    void checkedEmptyStringInput() {
            assertThatThrownBy(() -> runException(" ", "", "     "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorType.INPUT_NULL_ERROR.getMessage());
    }

    @Test
    @DisplayName("게임 실행 횟수 1회 미만시 예외 처리")
    void checkedTryGameNum() {
        assertThatThrownBy(() -> runException("0", "-10", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorType.GAME_TRY_COUNT_ERROR.getMessage());
    }

    @Test
    @DisplayName("중복된 이름이 존재할시 예외 처리")
    void checkedDuplicateCarNames() {
        assertThatThrownBy(() -> runException("kim,jun,kim"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorType.CAR_NAME_DUPLICATE_ERROR.getMessage());
    }

    @Test
    @DisplayName("게임 실행 횟수가 문자열일 경우 예외 처리")
    void checkedInvalidTryGameCount() {
        assertThatThrownBy(() -> runException("kim,jun","한 번"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorType.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
