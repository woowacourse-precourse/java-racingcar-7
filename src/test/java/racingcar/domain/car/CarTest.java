package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@DisplayName("랜덤값이 타겟값보다 크면 이동거리가 1만큼 증가한다.")
	@Test
	void move() {
		//given
		Car car = Car.from("roy");
		int expect = 1;

		//when
		car.move(4);

		//then
		assertThat(car.getMoveDistance()).isEqualTo(expect);
	}

	@DisplayName("랜덤값이 타겟값보다 작으면 이동거리가 증가하지 않는다")
	@Test
	void shouldNotMoveWhenNumberLessThanTarget() {
		// given
		Car car = Car.from("roy");

		// when
		car.move(3);

		// then
		assertThat(car.getMoveDistance()).isZero();
	}
}