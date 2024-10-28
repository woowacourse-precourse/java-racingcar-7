package racingcar.controller.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.exception.ErrorBase.CAR_COUNT_EXCEEDS_LIMIT;
import static racingcar.exception.ErrorBase.CAR_NAME_IS_EMPTY;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateCarTest {
    @Test
    void 쉼표로_구분된_자동차의_이름을_입력받는다() {
        String input = "pobi, woni, jun";

        List<String> cars = ValidateCar.validateName(input);

        assertThat(cars).hasSize(3)
                .containsExactlyInAnyOrder("pobi", "woni", "jun");
    }

    @Test
    void 자동차의_이름에_공백이_들어갈경우_제거한다() {
        // given
        String input = " pobi , woni     , jun         ";

        // when
        List<String> result = ValidateCar.validateName(input);

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 입력받은_문자열이_빈_문자열이면_예외를_발생시킨다(){
        String input = "";

        assertThatThrownBy(() -> ValidateCar.validateName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_IS_EMPTY.getMessage());
    }

    @Test
    void 쉼표로_구분한_자동차의_이름이_빈_문자열이면_예외를_발생시킨다(){
        String input = "car1, , car2";
        assertThatThrownBy(() -> ValidateCar.validateName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_IS_EMPTY.getMessage());
    }

    @Test
    void 입력받은_자동차의_개수가_1000개_이상이면_예외를_발생시킨다() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1001; i++) {
            sb.append(i).append(",");
        }

        assertThatThrownBy(() -> ValidateCar.validateName(sb.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_COUNT_EXCEEDS_LIMIT.getMessage());
    }
}