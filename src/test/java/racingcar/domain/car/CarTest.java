package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차 객체 생성 확인")
	void testCarCreation() {
		// Arrange
		String carName = "TestCar";
		MoveStrategy moveStrategy = new DummyMoveStrategy(false);

		// Act
		Car car = new Car(carName, moveStrategy);

		// Assert
		assertThat(car.getName()).isEqualTo(carName);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("move할 수 있을 때 위치 변경되어야 함")
	void testCarMovement() {
		// Arrange
		MoveStrategy moveStrategy = new DummyMoveStrategy(true);
		Car car = new Car("TestCar", moveStrategy);

		// Act
		car.move();

		// Assert
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("move할 수 없을 때 위치 변경되지 않아야 함")
	void testCarDoesNotMoveWhenNotMovable() {
		// Arrange
		MoveStrategy moveStrategy = new DummyMoveStrategy(false);
		Car car = new Car("TestCar", moveStrategy);

		// Act
		car.move();

		// Assert
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
