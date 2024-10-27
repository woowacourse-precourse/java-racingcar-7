package racingcar;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.common.util.RandomNumberGenerator;
import racingcar.domain.model.Car;
import racingcar.domain.model.CarList;
import racingcar.util.TestRandomNumberGenerator;

class CarListTest {

	private CarList carList;
	private RandomNumberGenerator randomNumberGenerator;

	@BeforeEach
	void setup() {
		carList = new CarList();
		randomNumberGenerator = new TestRandomNumberGenerator(5);
	}

	@Test
	void test_get_single_winner() {
		//given
		List.of("la", "lb", "lc", "ld").forEach(name -> carList.addCar(new Car(name.trim())));

		//when
		moveCar(0, 2);
		moveCar(1, 3);
		moveCar(2, 1);
		moveCar(3, 1);

		//then
		Assertions.assertEquals("lb", carList.getWinners().orElse(""));
	}

	@Test
	void test_get_multiple_winner() {
		//given
		List.of("la", "lb", "lc", "ld").forEach(name -> carList.addCar(new Car(name.trim())));

		//when
		moveCar(0, 2);
		moveCar(1, 2);
		moveCar(2, 1);
		moveCar(3, 2);

		//then
		Assertions.assertEquals("la, lb, ld", carList.getWinners().orElse(""));
	}

	void moveCar(int carIndex, int times) {
		for (int i = 0; i < times; ++i) {
			carList.getCar(carIndex).moveForward(randomNumberGenerator);
		}
	}

	@ParameterizedTest
	@MethodSource("provide_valid_car_names")
	void test_add_cars(List<String> names, int expected) {
		//when
		names.forEach(name -> carList.addCar(new Car(name.trim())));
		//then
		Assertions.assertEquals(expected, carList.getCount());
	}

	static Stream<Arguments> provide_valid_car_names() {
		return Stream.of(Arguments.of(List.of("la", "lb", "lc"), 3), Arguments.of(List.of("la", "lb"), 2),
			Arguments.of(List.of("la", "lb", "lc","ld"), 4));
	}

	@Test
	void test_throw_exception_when_names_is_null() {
		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> carList.addCar(new Car(null)));
	}

	@Test
	void test_throw_exception_when_names_is_empty() {
		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> carList.addCar(new Car(" ")));
	}

	@Test
	void test_throw_exception_when_over_car_list_index() {
		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> carList.getCar(5));
	}

}
