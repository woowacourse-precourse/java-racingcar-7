package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 레이싱카의이름을5자보다길게쓴경우() {
        Assertions.assertThatThrownBy(() -> Validator.validateCarNames(new String[]{"racingcar1", "racingcar2"}))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("경주할 자동차의 이름의 길이는 5자 이하가 되야 합니다.");
    }

    @Test
    void 시도할횟수에문자열을입력한경우(){
        Assertions.assertThatThrownBy(() -> Validator.validateRacingRound("6번"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("시도할 횟수는 정수 형태여야 합니다.");
    }
}
