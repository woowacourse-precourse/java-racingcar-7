package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarValidatorTest{

    @ParameterizedTest
    @DisplayName("자동차 이름을 잘못 입력했을 경우 예외가 발생한다")
    @ValueSource(strings = {"pobiii", "po   bi", ""})
    void isValidCarName_ExceptionTest(String carNameString){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCarValidator.isValidCarName(carNameString))
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


    @ParameterizedTest
    @DisplayName("입력받은 경주 횟수가 양의 정수가 아니라면 예외가 발생된다")
    @ValueSource(strings = {"-1", "0", "1.1", "", "hi"})
    void validateRacingAttemptCountTest(String racingAttemptCountString){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCarValidator.validateRacingAttemptCount(racingAttemptCountString))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



}
