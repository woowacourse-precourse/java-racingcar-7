package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차의 이름은 5자를 넘지 않는다")
    public void whenFiveMoreName_thenThrowException() {
        //when & then
        assertThrows(IllegalArgumentException.class, () -> Car.from("gyunho"));
    }

}