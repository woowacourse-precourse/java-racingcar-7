package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;

class CarTest {
	@DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
	@Test
	void createCarWithInvalidName() {
		assertThatThrownBy(() -> new Car("123456"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차는 4 이상의 숫자에서만 전진한다")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void moveCar(int number) {
		Car car = new Car("test");
		car.move(number);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("자동차는 3 이하의 숫자에서는 전진하지 않는다")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	void notMoveCar(int number) {
		Car car = new Car("test");
		car.move(number);
		assertThat(car.getPosition()).isEqualTo(0);
	}
}

