package racingcar.service;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.global.error.Error.NAME_BLANK_EXCEPION;
import static racingcar.global.error.Error.NAME_LENGTH_EXCEPION;
import static racingcar.global.error.Error.TRY_COUNT_EXCEPION;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.error.NameError;
import racingcar.global.error.TryCountError;

class RacingInputValidateServiceTest {

    private RacingInputValidateService racingInputValidateService;

    @BeforeEach
    void setting() {
        racingInputValidateService = new RacingInputValidateService();
    }

    @DisplayName("자동차 이름이 콤마로 잘 분리가 되는지 확인")
    @Test
    void 자동차_이름_콤마로_분리() {
        String input = "car1,car2,car3";
        assertEquals(racingInputValidateService.splitCarName(input), List.of("car1", "car2", "car3"));
    }

    @DisplayName("자동차 이름에 빈칸이 들어있으면 오류 발생")
    @Test
    void 자동차_이름_빈칸_오류() {

        assertThatThrownBy(() -> racingInputValidateService.validateCarName(List.of("car1", "")))
                .isInstanceOf(NameError.class)
                .hasMessage(NAME_BLANK_EXCEPION.getErrorMsg());
    }

    @DisplayName("자동차 이름에 null 들어있으면 오류 발생")
    @Test
    void 자동차_이름_null_오류() {

        assertThatThrownBy(() -> racingInputValidateService.validateCarName(Arrays.asList("car1", null)))
                .isInstanceOf(NameError.class)
                .hasMessage(NAME_BLANK_EXCEPION.getErrorMsg());
    }

    @DisplayName("자동차 이름의 길이가 5를 초과하면 오류")
    @Test
    void 자동차_이름_길이_5_초과_오류() {

        assertThatThrownBy(() -> racingInputValidateService.validateCarName(List.of("car1", "racingcar")))
                .isInstanceOf(NameError.class)
                .hasMessage(NAME_LENGTH_EXCEPION.getErrorMsg());
    }

    @DisplayName("시도횟수가 양의 정수인지 확인")
    @Test
    void 시도횟수_양의정수() {

        assertDoesNotThrow(() -> {
            racingInputValidateService.validateTryCount("1");
        });
    }

    @DisplayName("시도횟수가 0이면 오류 발생")
    @Test
    void 시도횟수_0_오류() {

        assertThatThrownBy(() -> racingInputValidateService.validateTryCount("0"))
                .isInstanceOf(TryCountError.class)
                .hasMessage(TRY_COUNT_EXCEPION.getErrorMsg());
    }

    @DisplayName("시도횟수가 음수이면 오류 발생")
    @Test
    void 시도횟수_음수_오류() {

        assertThatThrownBy(() -> racingInputValidateService.validateTryCount("-3"))
                .isInstanceOf(TryCountError.class)
                .hasMessage(TRY_COUNT_EXCEPION.getErrorMsg());
    }

    @DisplayName("시도횟수가 실수이면 오류 발생")
    @Test
    void 시도횟수_실수_오류() {

        assertThatThrownBy(() -> racingInputValidateService.validateTryCount("1.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRY_COUNT_EXCEPION.getErrorMsg());
    }
}