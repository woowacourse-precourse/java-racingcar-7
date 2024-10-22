package racingcar;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.model.CarList;

class CarListTest {

	private CarList carList;

	@BeforeEach
	void setup() {
		carList = new CarList();
	}

	@Test
	void test_get_single_winner() {
		//given
		carList.addCars(new String[] {"la", "lb", "lc", "ld"});

		//when
		moveCar(0, 2, 5);
		moveCar(1, 3, 5);
		moveCar(2, 1, 2);
		moveCar(3, 1, 5);

		//then
		Assertions.assertEquals("lb", carList.getWinner().get());
	}

	@Test
	void test_get_multiple_winner() {
		//given
		carList.addCars(new String[] {"la", "lb", "lc", "ld"});

		//when
		moveCar(0, 2, 5);
		moveCar(1, 2, 5);
		moveCar(2, 1, 2);
		moveCar(3, 2, 5);

		//then
		Assertions.assertEquals("la, lb, ld", carList.getWinner().get());
	}

	void moveCar(int carIndex, int times, int number) {
		for (int i = 0; i < times; ++i) {
			carList.getCar(carIndex).moveForward(number);
		}
	}

	@ParameterizedTest
	@MethodSource("provide_valid_car_names")
	void test_add_cars(String[] names, int expected) {
		//when
		carList.addCars(names);
		//then
		Assertions.assertEquals(expected, carList.getCount());
	}

	static Stream<Arguments> provide_valid_car_names() {
		return Stream.of(Arguments.of(new String[] {"la", "lb", "lc"}, 3), Arguments.of(new String[] {"la", "lb"}, 2),
			Arguments.of(new String[] {"la", "lb", "lc", "lb"}, 4));
	}

	@Test
	void test_throw_exception_when_names_is_null() {
		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> carList.addCars(null));
	}

	@Test
	void test_throw_exception_when_names_is_empty() {
		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> carList.addCars(new String[] {}));
	}

	@Test
	void test_throw_exception_when_over_car_list_index() {
		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> carList.getCar(5));
	}

}
