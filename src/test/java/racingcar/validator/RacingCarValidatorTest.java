package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarValidatorTest{

    @Test
    @DisplayName("자동차 이름을 잘못 입력했을 경우 예외발생")
    void isValidCarName_ExceptionTest(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCarValidator.isValidCarName("pobiiii"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCarValidator.isValidCarName("po  bi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCarValidator.isValidCarName(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("난수가 4 이상일 경우 true값이 반환된다")
    void carForwardTest(){
        //given
        int randomNumber = 4;

        //when
        boolean canForward = RacingCarValidator.canForward(randomNumber);

        //then
        assertThat(canForward).isTrue();
    }

    @Test
    @DisplayName("난수가 4보다 작을 경우 false값이 반환된다")
    void carForwardTest2(){
        //given
        int randomNumber = 3;

        //when
        boolean canForward = RacingCarValidator.canForward(randomNumber);

        //then
        assertThat(canForward).isFalse();
    }



}
