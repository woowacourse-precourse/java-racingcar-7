package racingcar.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.common.MockLoseRandom;
import racingcar.common.MockWinRandom;

class CarsTest {

	private CarValidator carValidator;

	@BeforeEach
	void init(){
		carValidator = new CarValidator();
	}

	@Test
	@DisplayName("자동차들의 이동 시도를 할 수 있다.")
	void cars_try_move(){
		// given
		Car car1 = new Car("자동차1", carValidator);
		Car car2 = new Car("자동차2", carValidator);
		Car car3 = new Car("자동차3", carValidator);

		// when
		Cars cars = new Cars(List.of(car1, car2, car3));
		cars.tryMove(new MockWinRandom());

		// then
		Assertions.assertThat(car1.getPosition()).isEqualTo(1);
		Assertions.assertThat(car2.getPosition()).isEqualTo(1);
		Assertions.assertThat(car3.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차 중에 승자를 반환할 수 있다.")
	void among_cars_winner_can_be_return(){
		// given
		Car car1 = new Car("자동차1", carValidator);
		car1.tryMove(new MockWinRandom());

		Car car2 = new Car("자동차2", carValidator);
		car2.tryMove(new MockWinRandom());

		Car car3 = new Car("자동차3", carValidator);
		car1.tryMove(new MockLoseRandom());

		// when
		Cars cars = new Cars(List.of(car1, car2, car3));
		List<Car> winners = cars.getWinners();

		// then
		Assertions.assertThat(winners.size()).isEqualTo(2);
		Assertions.assertThat(winners.get(0).getName()).isEqualTo("자동차1");
		Assertions.assertThat(winners.get(1).getName()).isEqualTo("자동차2");
	}

	@Test
	@DisplayName("수정 불가능한 자동차들의 목록을 반환할 수 있다.")
	void cars_can_return_unmodifiableList(){
		// given
		Car car1 = new Car("자동차1", carValidator);
		Car car2 = new Car("자동차2", carValidator);
		Car car3 = new Car("자동차3", carValidator);

		// when
		Cars cars = new Cars(List.of(car1, car2, car3));
		List<Car> currentCars = cars.getCurrentStatus();

		// then
		Assertions.assertThatThrownBy(() -> currentCars.set(2, null))
			.isInstanceOf(UnsupportedOperationException.class);

	}
}
