package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.NumberOfAttemptsDTO;

import static org.junit.jupiter.api.Assertions.*;


class NumberOfAttemptsTest {
    @Test
    @DisplayName("시도 횟수 에외 테스트")
    public void numberOfAttemptsExceptionTest() {
        //given
        String testString1 = "-1";
        String testString2 = "21";
        String testString3 = "test";
        //expect
        assertThrows(IllegalArgumentException.class, () -> new NumberOfAttempts(testString1));
        assertThrows(IllegalArgumentException.class, () -> new NumberOfAttempts(testString2));
        assertThrows(IllegalArgumentException.class, () -> new NumberOfAttempts(testString3));
    }

    @Test
    @DisplayName("시도 횟수 테스트")
    public void numberOfAttemptsTest() {
        //given
        String testString1 = "1";
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts(testString1);
        //when
        NumberOfAttemptsDTO numberOfAttemptsDTO = numberOfAttempts.getNumberOfAttemptsDTO();
        int number = numberOfAttemptsDTO.getNumber();
        //then
        assertEquals(number, 1);
    }
}