package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;
import racingcar.domain.name.Name;

public class CarTest {
	@Test
	@DisplayName("Car 객체가 올바르게 생성된다.")
	public void createCar() {
		Car car = new Car(new Name("hoon"));

		assertInstanceOf(Car.class, car);
	}

	@Test
	@DisplayName("4 이상의 숫자를 입력받을 시 score가 증가한다.")
	public void increaseScoreLargerThan4() {
		Car car = new Car(new Name("hoon"));

		car.processGame(4);

		assertEquals(1, car.getScore());
	}

	@Test
	@DisplayName("4 미만의 숫자를 입력받을 시 score가 증가하지 않는다.")
	public void notIncreaseScoreSmallerThan4() {
		Car car = new Car(new Name("hoon"));

		car.processGame(3);

		assertEquals(0, car.getScore());
	}
}
