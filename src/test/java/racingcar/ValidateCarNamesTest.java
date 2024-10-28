package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateCarNamesTest {
    @DisplayName("자동차 이름이 5자 이하일 경우")
    @Test
    void testNormalNames(){
        assertDoesNotThrow(() -> ValidateCarNames.validateCarNames("pobi,woni,jun"),
                "예외가 발생하지 않아야 합니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과할 경우")
    @Test
    void testLongerCarNames(){
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> ValidateCarNames.validateCarNames("pobi,woni,junnnnnnnnn"));
        assertEquals("이름이 5자 초과입니다.", thrown.getMessage());
    }

}
