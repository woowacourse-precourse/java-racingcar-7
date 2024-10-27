package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("Car 생성시 이름이 올바르게 저장되는지 확인하는 테스트")
    void initCarTest() {
        String carName = "Benz";

        Car benz = new Car(carName);

        assertEquals(carName, benz.getName(), "Car 이름이 올바르게 저장되지 않았습니다.");
    }
}
