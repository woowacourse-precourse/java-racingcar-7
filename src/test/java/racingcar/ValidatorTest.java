package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp(){
        validator = new Validator();
    }

    @Test
    void 시도횟수_공백_예외_테스트(){
        String input = "";
        assertThatThrownBy(()->validator.isValidNumberOfRounds(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_0이하의_정수_예외_테스트(){
        String input = "0";
        assertThatThrownBy(()->validator.isValidNumberOfRounds(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_정수_아닌_값_예외_테스트(){
        String input = "A";
        assertThatThrownBy(()->validator.isValidNumberOfRounds(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
