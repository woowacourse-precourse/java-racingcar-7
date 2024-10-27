package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("차 이동 시 위치 증가 확인")
    @Test
    public void testCarMove() {
        // given (사전 준비)
        Car car = new Car("test");

        // when (테스트 진행할 범위)
        car.move();

        // then (범위에 대한 결과 검증)
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("차 이름이 올바르게 설정되는지 확인")
    @Test
    public void testCarCorrectName() {
        // given (사전 준비)
        Car car = new Car("test");

        // when (테스트 진행할 범위)
        String carName = car.getName();

        // then (범위에 대한 결과 검증)
        assertThat(carName).isEqualTo("test");
    }

    @DisplayName("차의 초기 위치는 0이어야 한다")
    @Test
    public void testInitialPosition() {
        // given (사전 준비)
        Car car = new Car("test");

        // when (테스트 진행할 범위)
        int initialPosition = car.getPosition();

        // then (범위에 대한 결과 검증)
        assertThat(initialPosition).isEqualTo(0);
    }

}