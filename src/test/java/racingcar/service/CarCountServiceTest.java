package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCountServiceTest {

    final CarCountService carCountService = new CarCountService();

    @Test
    @DisplayName("숫자 형태가 아닌 입력이 들어오는 경우 - 문자")
    public void notNumberCarCount() {
        String count = "aa";
        assertThrows(IllegalArgumentException.class, () -> carCountService.getTryCountFromString(count));
    }

    @Test
    @DisplayName("숫자 형태가 아닌 입력이 들어오는 경우 - 빈 문자열")
    public void emptyCarCount() {
        String count = "";
        assertThrows(IllegalArgumentException.class, () -> carCountService.getTryCountFromString(count));
    }

    @Test
    @DisplayName("숫자 형태가 아닌 입력이 들어오는 경우 - 공백")
    public void gapCarCount() {
        String count = " ";
        assertThrows(IllegalArgumentException.class, () -> carCountService.getTryCountFromString(count));
    }

    @Test
    @DisplayName("정수 형태가 아닌 입력이 들어오는 경우")
    public void notIntegerCarCount() {
        String count = "1.23";
        assertThrows(IllegalArgumentException.class, () -> carCountService.getTryCountFromString(count));
    }

    @Test
    @DisplayName("올바른 정수 형태의 입력이 들어오는 경우")
    public void validCarCount() {
        String count = "3";
        assert carCountService.getTryCountFromString(count) == 3;
    }
}