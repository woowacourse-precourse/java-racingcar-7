package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    @DisplayName("입력 문자열을 받아 자동차 객체 리스트를 생성한다.")
    void createCarsFromInput() {
        // given
        CarFactory carFactory = new CarFactory(new CommaCarNameTokenizer());
        String input = "pobi,woni";

        // when
        var cars = carFactory.createCarsFromInput(input);

        // then
        assertAll(
            () -> assertEquals(2, cars.size()),
            () -> assertEquals("pobi", cars.get(0).getName()),
            () -> assertEquals("woni", cars.get(1).getName())
        );
    }
}
