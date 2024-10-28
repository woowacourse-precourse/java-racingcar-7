package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

	public Cars(String[] players) {
		validateDuplicateName(players);

		cars = Arrays.stream(players)
				.map(Car::new)
				.toList();
	}

	Cars(List<Car> cars) {
		this.cars = cars;
	}

	private void validateDuplicateName(String[] names) {
		long distinctNameCount = Arrays.stream(names)
				.map(String::trim)
				.distinct()
				.count();

		if (distinctNameCount != names.length) {
			throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
		}
	}

	public void run() {
		cars.forEach(car ->
				car.move(() ->
						Randoms.pickNumberInRange(0, 9)
				)
		);

		System.out.println(); // 회차 별 실행 결과 출력의 개행을 위한 라인
	}

	@SuppressWarnings("OptionalGetWithoutIsPresent")
	public String getWinners() {
		Car winner = cars.stream()
				.max(Comparator.comparing(Car::getPosition))
				.get();// never return null

		return cars.stream()
				.filter(car -> car.isWinner(winner))
				.map(Car::getName)
				.collect(Collectors.joining(", "));
	}
}
