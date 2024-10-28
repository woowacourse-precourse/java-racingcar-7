package racingcar.utils;


import org.junit.jupiter.api.*;
import racingcar.utils.RandomNumber;

class randomNumberTest {
    @DisplayName("랜덤한 숫자를 벗어나는지 체크")
    @Test
    void check_NumberRange() {
        int maxFound = 0;
        boolean foundNine = false;
        for (int i = 0; i < 100; i++) {
            int num = RandomNumber.getNumber();
            Assertions.assertTrue(num >= 0 && num <= 9);
            if (num == 9) foundNine = true;

            maxFound = Math.max(maxFound, num);
        }
        Assertions.assertTrue(foundNine, () -> "9가 한번도 생성 안됨");
        Assertions.assertEquals(9, maxFound);
    }


}