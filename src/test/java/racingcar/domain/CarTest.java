package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.common.MockLoseRandom;
import racingcar.common.MockWinRandom;

class CarTest {
	private CarValidator carValidator;

	@BeforeEach
	void init(){
		carValidator = new CarValidator();
	}

	@Test
	@DisplayName("차 이름은 5글자를 초과할 수 없다.")
	void car_name_cannot_exceed_5(){
		// given
		String carName = "5글자 초과입니다.";

		// when, then
		Assertions.assertThatThrownBy(() -> new Car(carName, carValidator))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("차 이름은 5글자를 초과할 수 없습니다.");
	}

	@Test
	@DisplayName("초기 생성된 자동차의 위치는 0이다.")
	void car_initial_position_is_0(){
		// given
		String carName = "자동차1";

		// when, then
		Car car = new Car(carName, carValidator);
		Assertions.assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("랜덤값이 4이상이면 1칸 앞으로 전진한다.")
	void random_value_at_least_4_move_1(){
		// given
		String carName = "자동차1";

		// when, then
		Car car = new Car(carName, carValidator);
		car.tryMove(new MockWinRandom());
		Assertions.assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("랜덤값이 4미만이면 이동하지 않는다.")
	void random_value_below_4_not_move(){
		// given
		String carName = "자동차1";

		// when, then
		Car car = new Car(carName, carValidator);
		car.tryMove(new MockLoseRandom());
		Assertions.assertThat(car.getPosition()).isEqualTo(0);
	}
}
