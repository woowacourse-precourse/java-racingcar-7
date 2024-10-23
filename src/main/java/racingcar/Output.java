package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Output {

	public static void printResult(List<Car> cars, int tryCounts) {
		System.out.println("실행 결과");
		for (int i = 0; i < tryCounts; i++) {
			randomizeRace(cars);
			printRace(cars);
		}
		printWinner(Winner.contain(cars));
	}

	// 메서드 구분 필요
	public static void randomizeRace(List<Car> cars) {
		int randomNum;

		for (Car car : cars) {
			randomNum = Randoms.pickNumberInRange(0, 9);
			if (randomNum >= 4) {
				car.distance++;
			}
		}
	}

	public static void printRace(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.name + " : " + displayDistance(car));
		}
		System.out.println();
	}

	public static String displayDistance(Car car) {
		String distance = "";
		for (int i = 0; i < car.distance; i++) {
			distance += "-";
		}
		return distance;
	}

	public static void printWinner(List<Car> winners) {
		System.out.print("최종 우승자 : ");

		if (winners.size() == 1) {
			System.out.print(winners.get(0).name);
			return;
		}

		System.out.println(Winner.makeList());
	}
}
