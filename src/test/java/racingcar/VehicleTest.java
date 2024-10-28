package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vehicle.Car;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VehicleTest {

    @Test
    @DisplayName("Car 객체의 시도횟수가 음수로 초기화되는 경우")
    void 시도횟수_음수() {
        assertThrows(IllegalArgumentException.class, () -> new Car("java", -1));
    }

    @Test
    @DisplayName("Car 객체의 이름이 6글자 이상으로 초기화되는 경우")
    void 이름_6글자_초과() {
        assertThrows(IllegalArgumentException.class, () -> new Car("javajigi", 3));
    }

}
