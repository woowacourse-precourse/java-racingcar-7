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

    @Test
    void 자동차_입력_6글자_이상_예외_테스트(){
        String input = "Car1,Car2,Car119";
        assertThatThrownBy(()->validator.isValidCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_입력_2대_미만_예외_테스트(){
        String input = "Car1";
        assertThatThrownBy(()->validator.isValidCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_입력_중복값_예외_테스트(){
        String input = "Car1,Car1,Car2";
        assertThatThrownBy(()->validator.isValidCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
