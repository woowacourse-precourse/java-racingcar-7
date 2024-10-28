package racingcar.racinggame.race.car;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

	@DisplayName("자동차를 생성할 수 있다.")
	@Test
	void create() {
		// given
		String carName = "frod";

		// when
		Car car = Car.create(carName);

		// then
		assertThat(car)
			.extracting("name", "moveDistance")
			.containsExactly(carName, 0);

	}

	@DisplayName("자동차는 이름이 있어야 생성할 수 있다.")
	@Test
	void createWithBlankName() {
		// given
		String carName = "";

		// when // then
		assertThatThrownBy(() -> Car.create(carName))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름이 존재해야 합니다.");
	}

	@DisplayName("자동차의 이름은 5글자를 넘을 수 없다.")
	@Test
	void createWithOverFlowNameLength() {
		// given
		String carName = "123456";

		// when // then
		assertThatThrownBy(() -> Car.create(carName))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름은 5자 이하만 가능합니다.");
	}

	@DisplayName("자동차는 4이상의 숫자가 주어진 경우에만 1칸 전진한다.")
	@CsvSource({"0,0", "3,0", "4,1", "9,1"})
	@ParameterizedTest(name = "무작위 값이 {0}인 경우 {1}칸 전진한다")
	void move(int randomValue, int expectedMoveDistance) {
		// given
		Car car = Car.create("frod");

		// when
		car.move(randomValue);

		// then
		assertThat(car.getMoveDistance()).isEqualTo(expectedMoveDistance);
	}

	@DisplayName("자동차 이동에 사용되는 값은 0~9 사이의 무작위 값이다")
	@ValueSource(ints = {-9, -1, 10, 11})
	@ParameterizedTest(name = "무작위 값이 {0}인 경우는 허용하지 않는다")
	void moveWithOverFlowRandomValueRange(int randomValue) {
		// given
		Car car = Car.create("frod");

		// when // then
		assertThatThrownBy(() -> car.move(randomValue))
			.isInstanceOf(IllegalStateException.class)
			.hasMessage("무작위 값의 범위는 0~9 사이입니다.");
	}

	@DisplayName("가장 멀리간 차량인지 확인할 수 있다.")
	@Test
	void isFurthestIn() {
		// given
		Car car01 = Car.create("aaa");
		Car car02 = Car.create("bbb");
		Car car03 = Car.create("ccc");
		List<Car> cars = asList(car01, car02, car03);

		car01.move(5);
		car01.move(5);

		car02.move(5);

		// when
		boolean expectedCar01 = car01.isFurthestIn(cars);
		boolean expectedCar02 = car02.isFurthestIn(cars);
		boolean expectedCar03 = car03.isFurthestIn(cars);

		// then
		assertAll(
			() -> assertThat(expectedCar01).isTrue(),
			() -> assertThat(expectedCar02).isFalse(),
			() -> assertThat(expectedCar03).isFalse()
		);
	}
}