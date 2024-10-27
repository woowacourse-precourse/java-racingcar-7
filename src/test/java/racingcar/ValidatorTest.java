package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.view.Validator;

public class ValidatorTest {
    @Test
    void 이름에_대한_예외_처리() {
        Assertions.assertThatThrownBy(() -> Validator.validateCarNames(new String[]{"racingcar1", "racingcar2"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 시도_문자열_입력_예외_처리(){
        Assertions.assertThatThrownBy(() -> Validator.validateRacingRound("6번"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 정수 형태여야 합니다.");
    }

    @Test
    void 입력없음_예외_테스트() {
        Assertions.assertThatThrownBy(() -> Validator.handleEmptyInputException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아무것도 입력하지 않았습니다. 게임을 진행할 수 없습니다.");
    }
}