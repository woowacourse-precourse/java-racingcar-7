package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

	private Car car;

	@BeforeEach
	void setFixture() {
		car = new Car("suby");
	}

	@Test
	void 자동차_이름_문자열_반환() {
		assertEquals("suby", car.getName());
	}

	@Test
	void 자동차_위치_정수_반환() {
		assertEquals(0, car.getPosition());
	}

	@Test
	void 자동차는_컨디션이_4_이상이면_전진() {
		Integer initialPosition = car.getPosition();
		Integer condition = 4;
		car.moveByCondition(condition);
		assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
	}
}