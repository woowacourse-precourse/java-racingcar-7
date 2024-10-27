package racingcar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TryNumberTest {

    @Test
    public void testSetTryNumberWithValidInput() {
        TryNumber tryNumber = new TryNumber();
        tryNumber.setTryNumber("5");
        assertEquals(5, tryNumber.getTryNumber());
    }

    @Test
    public void testSetTryNumberWithNegativeInput() {
        TryNumber tryNumber = new TryNumber();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tryNumber.setTryNumber("-1");
        });
        assertEquals("시도 횟수는 0 이상의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    public void testSetTryNumberWithNonDigitInput() {
        TryNumber tryNumber = new TryNumber();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tryNumber.setTryNumber("abc");
        });
        assertEquals("시도 횟수는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    public void testSetTryNumberWithNullInput() {
        TryNumber tryNumber = new TryNumber();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tryNumber.setTryNumber(null);
        });
        assertEquals("시도 횟수를 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    public void testSetTryNumberWithEmptyInput() {
        TryNumber tryNumber = new TryNumber();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tryNumber.setTryNumber("");
        });
        assertEquals("시도 횟수를 입력하지 않았습니다.", exception.getMessage());
    }
}
