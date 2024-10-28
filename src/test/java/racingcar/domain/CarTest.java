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

	@Test
	@DisplayName("주입받은 난수가 4 이상일 경우, 자동차를 이동시킨다.")
	void Move_If_Random_Number_Greater_Than_Or_Equal_To_4() {
		// given
		Car car = new Car("test");

		// when
		car.move(5);

		// then
		assertThat(car.getDistance()).isEqualTo(1);
	}

	@Test
	@DisplayName("주입받은 난수가 4 미만일 경우, 자동차를 정지시킨다.")
	void Stop_If_Random_Number_Less_Than_4() {
		// given
		Car car = new Car("test");

		// when
		car.move(3);

		// then
		assertThat(car.getDistance()).isZero();
	}
}