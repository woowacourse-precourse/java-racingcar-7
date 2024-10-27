package racingcar.viewHandler.api;

import org.junit.jupiter.api.Test;
import racingcar.viewHandler.api.message.ExceptionMessageImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.viewHandler.api.message.ErrorMessage.라운드_숫자_입력_에러;
import static racingcar.viewHandler.api.message.ErrorMessage.라운드_양수_입력_에러;
import static racingcar.viewHandler.api.message.ErrorMessage.차_이름_크기_에러;
import static racingcar.viewHandler.api.message.ErrorMessage.차_입력_에러;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void 차_입력_최소2개_확인() {
        List<String> carnames = List.of("pobi");
        assertThatThrownBy(() -> {
            validator.validateMinCarCount(carnames);
        }).isInstanceOf(ExceptionMessageImpl.class)
                .hasMessage(차_입력_에러.getMessage());
    }

    @Test
    void 차_이름_크기_최대5_확인() {
        List<String> carnames = List.of("pobi", "raccoon");
        assertThatThrownBy(() -> {
            validator.validateCarNameLength(carnames);
        }).isInstanceOf(ExceptionMessageImpl.class)
                .hasMessage(차_이름_크기_에러.getMessage());
    }

    @Test
    void 라운드_입력_숫자만_확인() {
        String totalRound = "five";
        assertThatThrownBy(() -> {
            validator.tryParserToInt(totalRound);
        }).isInstanceOf(ExceptionMessageImpl.class)
                .hasMessage(라운드_숫자_입력_에러.getMessage());
    }

    @Test
    void 라운드_입력_음수_확인() {
        String totalRound = "-5";
        assertThatThrownBy(() -> {
            Integer number = validator.tryParserToInt(totalRound);
            validator.validatePositiveNumber(number);
        }).isInstanceOf(ExceptionMessageImpl.class)
                .hasMessage(라운드_양수_입력_에러.getMessage());
    }

    @Test
    void 라운드_입력_자연수_확인() {
        String totalRound = "5.6";
        assertThatThrownBy(() -> {
            validator.tryParserToInt(totalRound);
        }).isInstanceOf(ExceptionMessageImpl.class)
                .hasMessage(라운드_숫자_입력_에러.getMessage());
    }
}