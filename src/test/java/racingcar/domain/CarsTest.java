package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.name.Name;

public class CarsTest {
	@Test
	@DisplayName("Cars 객체가 올바르게 생성된다.")
	public void createCars() {
		Name name1 = new Name("hoon");
		Name name2 = new Name("pobi");

		List<Name> names = new ArrayList<>();
		names.add(name1);
		names.add(name2);

		Cars cars = Cars.from(names);

		assertInstanceOf(Cars.class, cars);
	}

	@Test
	@DisplayName("제일 높은 점수를 가져온다.")
	public void getMaxScore() {
		Car car1 = new Car(new Name("hoon"), 5);
		Car car2 = new Car(new Name("pobi"), 2);
		Car car3 = new Car(new Name("tae"), 5);

		List<Car> racingCars = new ArrayList<>();

		racingCars.add(car1);
		racingCars.add(car2);
		racingCars.add(car3);

		Cars cars = new Cars(racingCars);
		int maxScore = cars.getMaxScore();

		assertEquals(5, maxScore);
	}

	@Test
	@DisplayName("제일 높은 점수인 자동차가 하나일 때 그 이름을 제대로 가져온다.")
	public void getMaxScoreCarName() {
		Car car1 = new Car(new Name("hoon"), 4);
		Car car2 = new Car(new Name("pobi"), 2);
		Car car3 = new Car(new Name("tae"), 5);
		List<Car> racingCars = new ArrayList<>();

		racingCars.add(car1);
		racingCars.add(car2);
		racingCars.add(car3);

		Cars cars = new Cars(racingCars);
		List<Name> maxScoreCarName = cars.getMaxScoreCarNames();

		assertEquals(1, maxScoreCarName.size());
		assertEquals("hoon", maxScoreCarName.getFirst().getName());
	}

	@Test
	@DisplayName("제일 높은 점수인 자동차가 여러대일 때 그 이름들을 제대로 가져온다.")
	public void getMaxScoreCarNames() {
		Car car1 = new Car(new Name("hoon"), 5);
		Car car2 = new Car(new Name("pobi"), 2);
		Car car3 = new Car(new Name("tae"), 5);
		List<Car> racingCars = new ArrayList<>();

		racingCars.add(car1);
		racingCars.add(car2);
		racingCars.add(car3);

		Cars cars = new Cars(racingCars);
		List<Name> maxScoreCarName = cars.getMaxScoreCarNames();

		assertEquals(2, maxScoreCarName.size());
		assertEquals(maxScoreCarName, cars.getMaxScoreCarNames());
	}
}
