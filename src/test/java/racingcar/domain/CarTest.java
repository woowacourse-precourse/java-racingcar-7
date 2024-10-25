package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	@Test
	@DisplayName("자동차 이름 생성 테스트")
	void 자동차_이름_저장() {
		Car car1 = new Car("car1");
		int carName = car1.getCarName().length();

		assertThat(carName).isEqualTo(4);
	}

	@Test
	@DisplayName("자동차 전진 기능 테스트")
	void 자동차_전진_테스트() {
		Car car1 = new Car("car1");
		assertThat(car1.getMovement()).isEqualTo(0);

		car1.movement();
		assertThat(car1.getMovement()).isEqualTo(1);
	}


}