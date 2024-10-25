package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.InputValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class InputViewTest {

    private final InputValidator testInputValidator = new InputValidator();

    @Test
    @DisplayName("자동차 이름이 정상적으로 쉼표로 구분되어 리스트로 반환되는지 테스트")
    void testGetCarsSuccessfully() {

        String input = "uni,jini,huni";

        List<String> carNames = testInputValidator.processCarNames(input);

        assertThat(carNames).containsExactly("uni", "jini", "huni");
    }

    @Test
    @DisplayName("자동차 이름이 아예 비어있을 때 IllegalArgumentException이 발생하는지 테스트")
    void testEmptyInputThrowsException() {

        String input = "";

        assertThatThrownBy(() -> testInputValidator.processCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해 주세요.");
    }

    @Test
    @DisplayName("자동차 이름 중 하나라도 비어있으면 IllegalArgumentException이 발생하는지 테스트")
    void testEmptyCarNameThrowsException() {

        String input = "uni,,huni";


        assertThatThrownBy(() -> testInputValidator.processCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상일 때 IllegalArgumentException이 발생하는지 테스트")
    void testCarNameLongThrowsException() {

        String input = "uniiiii,huni";


        assertThatThrownBy(() -> testInputValidator.processCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }


}
