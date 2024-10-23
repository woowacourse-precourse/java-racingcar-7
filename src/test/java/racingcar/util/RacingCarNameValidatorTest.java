package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.RacingCarNameValidator.checkRacingCarNameListIsAvailable;

class RacingCarNameValidatorTest {
    @Test
    @DisplayName("Case 1: 5 이상의 길이를 가지는 값이 있는 경우")
    void CarRacingNameTestCase_Length() {
        // given
        String input = "nameIs,hello,test";  // 5자를 초과하는 값이 있는 경우

        // then
        assertThrows(IllegalArgumentException.class,
                // when
                () -> checkRacingCarNameListIsAvailable(input));
    }

    @Test
    @DisplayName("Case 2: 중간에 길이가 0인 값이 있는 경우")
    void CarRacingNameTestCase_EmptyName() {
        // given
        String input = "name,,test";  // 중간에 빈 문자열이 있는 경우

        // then
        assertThrows(IllegalArgumentException.class,
                // when
                () -> checkRacingCarNameListIsAvailable(input));
    }

    @Test
    @DisplayName("Case 3: 앞에 빈 문자열이 있는 경우")
    void CarRacingNameTestCase_EmptyNameAtStart() {
        // given
        String input = ",name,test";  // 처음에 빈 문자열이 있는 경우

        // then
        assertThrows(IllegalArgumentException.class,
                // when
                () -> checkRacingCarNameListIsAvailable(input));
    }

    @Test
    @DisplayName("Case 4: 뒤에 빈 문자열이 있는 경우")
    void CarRacingNameTestCase_EmptyNameAtEnd() {
        // given
        String input = "name,test,";  // 마지막에 빈 문자열이 있는 경우

        // then
        assertThrows(IllegalArgumentException.class,
                // when
                () -> checkRacingCarNameListIsAvailable(input));
    }

    @Test
    @DisplayName("Case 5: 중복 문자열이 존재하는 경우")
    void CarRacingNameTestCase_Duplicate() {
        // given
        String input = "name,test,name";  // 중복 문자열이 있는 경우

        // then
        assertThrows(IllegalArgumentException.class,
                // when
                () -> checkRacingCarNameListIsAvailable(input));
    }
}