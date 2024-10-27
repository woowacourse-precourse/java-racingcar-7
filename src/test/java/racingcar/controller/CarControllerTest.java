package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarControllerTest {

	CarController controller = new CarController();

	@Test
	void 자동차_움직임_출력() {
		PrintStream originalOut = System.out;

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		Car car1 = new Car("car1");
		Car car2 = new Car("car2");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);

		controller.carMovementProcess(cars, 5);

		String output = outputStream.toString().trim();

		String expectedOutput = "출력테스트";
		assertThat(output).isEqualTo(expectedOutput);

		System.setOut(originalOut);
	}
}