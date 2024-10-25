package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {

    @Test
    void 자동차_이름을_공백으로_입력받는_경우_예외테스트(){
        assertThatThrownBy(() ->   InputValidator.validateCarNamesInput(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱_시도_횟수를_공백으로_입력받는_경우_예외테스트(){
        assertThatThrownBy(() ->   InputValidator.validateCarNamesInput(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
