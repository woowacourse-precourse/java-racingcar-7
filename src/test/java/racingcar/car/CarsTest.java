package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

class CarsTest {

	@Nested
	class 이름_중복_체크Test {
		@Test
		void 성공() {
			String[] names = new String[]{"pobi", "jun", "woni"};

			assertThatNoException()
					.isThrownBy(() -> new Cars(names));
		}

		@Test
		void 실패() {
			String[] names = new String[]{"pobi", "jun", "pobi"};

			assertThatIllegalArgumentException()
					.isThrownBy(() -> new Cars(names));
		}
	}

	@Nested
	class 우승자_찾기Test {
		@Test
		void 단독_우승() {
			Car car1 = new Car("pobi");
			Car car2 = new Car("jun");
			Car car3 = new Car("woni");

			car1.move(() -> 5);
			car2.move(() -> 3);
			car3.move(() -> 2);

			Cars cars = new Cars(List.of(car1, car2, car3));

			assertThat(cars.getWinners())
					.contains("pobi")
					.doesNotContain("jun")
					.doesNotContain("woni");
		}

		@Test
		void 공동_우승() {
			Car car1 = new Car("pobi");
			Car car2 = new Car("jun");
			Car car3 = new Car("woni");

			car1.move(() -> 5);
			car2.move(() -> 6);
			car3.move(() -> 2);

			Cars cars = new Cars(List.of(car1, car2, car3));

			assertThat(cars.getWinners())
					.contains("pobi")
					.contains("jun")
					.doesNotContain("woni");
		}

		@Test
		void 공동_우승_모든_차가_제자리() {
			Cars cars = new Cars(
					List.of(
							new Car("pobi"),
							new Car("jun"),
							new Car("woni")));

			assertThat(cars.getWinners())
					.contains("pobi")
					.contains("jun")
					.contains("woni");
		}
	}
}
