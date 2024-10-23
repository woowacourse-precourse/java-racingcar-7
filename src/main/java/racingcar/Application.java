package racingcar;

/*
간단한 로직 완료, 리팩토링 필요, 예외 처리 필요, class 파일 패키지별 분리 필요
 */

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		String[] carNames = Input.inputCarNames();
		int tryCounts = Input.inputTryCounts();

		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < carNames.length; i++) {
			cars.add(new Car(carNames[i]));
		}
		Output.printResult(cars, tryCounts);
	}
}
