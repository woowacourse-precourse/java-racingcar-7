package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.RacingNumberValidator.checkNumberOfRacingIsAvailable;

class RacingNumberValidatorTest {

    @Test
    @DisplayName("Case 0 : 정상은 잡지 않는가? ")
    void checkTheGoodInput(){
        //given
        String input = "1234";

        //when
        checkNumberOfRacingIsAvailable(input);

        //then -> No Error Return 0;

    }

    @Test
    @DisplayName("Case 1 : 정수가 입력되었는가?")
    void checkTheStringIsLiteral(){
        //given
        String input = "?";

        //then
        Assertions.assertThrows(IllegalArgumentException.class,

                //when
                () -> checkNumberOfRacingIsAvailable(input));
    }

    @Test
    @DisplayName("Case 2 : 0보다 큰 양의 정수인가? ")
    void checkTheStringIsPositiveLiteral(){
        //given
        String input = "-1";

        //then
        Assertions.assertThrows(IllegalArgumentException.class,

                //when
                () -> checkNumberOfRacingIsAvailable(input));
    }



}