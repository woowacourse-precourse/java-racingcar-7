package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 클래스 테스트")
class CarTest {
	@Test
	@DisplayName("Car 객체를 처음 생성했을 떄, 이동 거리를 0으로 초기화한다.")
	void Initialize_Distance_When_Car_Object_Created() {
		// given
		Car car = new Car("test");

		// when
		int distance = car.getDistance();

		// then
		assertThat(distance).isZero();
	}
}