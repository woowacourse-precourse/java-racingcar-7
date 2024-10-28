package racingcar;

import car.Car;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.InputValidator;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void init(){
        inputValidator = new InputValidator();
    }

    @Test
    void 빈_문자열_예외_테스트(){
        assertThatThrownBy(()->inputValidator.validateCarName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_없는_자동차_예외_테스트(){
        assertThatThrownBy(()->inputValidator.validateCarName("A,,B,C"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 널값_문자열_예외_테스트(){
        assertThatThrownBy(()->inputValidator.validateCarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_6_이상인_문자열_예외_테스트(){
        assertThatThrownBy(()->inputValidator.validateCarName("ABCDEFGHHH,SD,S"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_이름_중복_예외_테스트(){
        assertThatThrownBy(()->inputValidator.validateCarName("A,B,B,C,D,E"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자값이_아닌_이동횟수_예외_테스트(){
        assertThatThrownBy(()->inputValidator.validateMoveCount("three"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동횟수_0_예외_테스트(){
        assertThatThrownBy(()->inputValidator.validateMoveCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동횟수_음수_예외_테스트(){
        assertThatThrownBy(()->inputValidator.validateMoveCount("-23"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_이동횟수_예외_테스트(){
        assertThatThrownBy(()->inputValidator.validateMoveCount("three"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 널값_이동횟수_예외_테스트(){
        assertThatThrownBy(()->inputValidator.validateMoveCount(null))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
