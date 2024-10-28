package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차 이름이 5자 넘어갈 경우 예외를 발생시키는지 테스트")
    @Test
    public void invalidCarNameTooLongTest() {
        String[] invalidCarNames = {"pobi12345", "karina"};
        for (String name : invalidCarNames) {
            assertThrows(IllegalArgumentException.class, () -> new Car(name), "차 이름은 5자 이하여야 합니다.");
        }
    }

    @DisplayName("자동차 이름이 공백일 경우 예외를 발생시키는지 테스트")
    @Test
    public void invalidCarNameNullTest() {
        String[] invalidCarNames = {null,""," "};
        for (String name : invalidCarNames) {
            assertThrows(IllegalArgumentException.class, () -> new Car(name), "차 이름은 공백일 수 없습니다.");
        }
    }
}
