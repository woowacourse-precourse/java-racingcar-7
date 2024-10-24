package racingcar;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.common.util.RandomNumberGenerator;
import racingcar.domain.model.Car;
import racingcar.util.TestRandomNumberGenerator;

class CarTest {

	@ParameterizedTest
	@MethodSource("provide_input_for_test_move_forward")
	void test_move_forward(String name, int number, int position) {
		Car car = new Car(name);
		RandomNumberGenerator randomNumberGenerator = new TestRandomNumberGenerator(number);
		car.moveForward(randomNumberGenerator);

		Assertions.assertEquals(position, car.getPosition());
	}

	static Stream<Arguments> provide_input_for_test_move_forward() {
		return Stream.of(Arguments.of("la", 0, 0), Arguments.of("lb", 1, 0),
			Arguments.of("lc", 2, 0), Arguments.of("ld", 3, 0), Arguments.of("le", 4, 1),
			Arguments.of("lf", 5, 1), Arguments.of("lg", 6, 1), Arguments.of("lh", 7, 1),
			Arguments.of("li", 8, 1), Arguments.of("lj", 9, 1));
	}

}
