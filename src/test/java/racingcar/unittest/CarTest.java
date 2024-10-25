package racingcar.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

class CarTest extends NsTest {

    @Test
    @DisplayName("Car 객체 생성 시 이름이 정상적으로 설정되는지 테스트")
    void createCar_withName_shouldSetName() {
        // Given
        String name = "pobi";

        // When
        Car car = new Car(name);

        // Then
        assertThat(car.getName()).isEqualTo(name);
    }

    @Override
    public void runMain() {
        // 해당 클래스에서는 runMain을 사용하지 않습니다.
    }
}
