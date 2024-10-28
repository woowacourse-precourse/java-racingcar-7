package racingcar.controller.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorBase.CAR_COUNT_EXCEEDS_LIMIT;
import static racingcar.exception.ErrorBase.CAR_NAME_IS_BETWEEN_ONE_AND_FIVE;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarValidatorTest extends ValidatorTest<List<String>>{
    @Override
    protected Validator<List<String>> getValidator() {
        return new CarValidator();
    }

    @Test
    void 쉼표로_구분된_자동차의_이름을_입력받는다() {
        String input = "pobi, woni, jun";

        List<String> cars = getValidator().validate(input);

        assertThat(cars).hasSize(3)
                .containsExactlyInAnyOrder("pobi", "woni", "jun");
    }

    @Test
    void 자동차의_이름에_공백이_들어갈경우_제거한다() {
        // given
        String input = " pobi , woni     , jun         ";

        // when
        List<String> result = getValidator().validate(input);

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 쉼표로_구분한_자동차의_이름이_빈_문자열이면_예외를_발생시킨다(){
        String input = "car1, , car2";
        assertThatThrownBy(() -> getValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_IS_BETWEEN_ONE_AND_FIVE.getMessage());
    }

    @Test
    void 자동차_이름이_최대글자를_초과하면_예외를_발생시킨다() {
        String input = "a".repeat(CarValidator.NAME_LENGTH + 1);

        assertThatThrownBy(() -> getValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_IS_BETWEEN_ONE_AND_FIVE.getMessage());
    }

    @Test
    void 입력받은_자동차의_개수가_최대개수를_초과하면_예외를_발생시킨다() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CarValidator.MAX_CARS + 1; i++) {
            sb.append(i).append(",");
        }

        assertThatThrownBy(() -> getValidator().validate(sb.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_COUNT_EXCEEDS_LIMIT.getMessage());
    }


}