package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarMachine {

	private Map<String, String> carForward = new LinkedHashMap<>();
	private List<String> cars = new ArrayList<>();
	private List<String> winner = new ArrayList<>();
	private int tryNumber;

	public void run() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		cars = Arrays.asList(Console.readLine().split(","));

		// 1. 이름 입력 시 이름을 입력하지 않은 경우
		if(cars.get(0).equals("")){
			throw new IllegalArgumentException("이름을 입력해 주세요.");
		}

		// 2. 이름 입력 시 5자 이상인 경우
		for (String car : cars) {
			if (car.length() > 4){
				throw new IllegalArgumentException("5자 미만의 이름을 입력해 주세요.");
			}
		}

		// 3. 이름 입력 시 쉼표(,)가 맨 앞에 있거나 맨 뒤에 존재하는 경우
		if(cars.get(0).startsWith(",") || cars.get(cars.size()-1).endsWith(",")){
			throw new IllegalArgumentException("쉼표(,)로 시작하거나 끝날 수 없습니다.");
		}

		System.out.println("시도할 횟수는 몇 회인가요?");

		try {
			tryNumber = Integer.parseInt(Console.readLine());

			// 6. 시도 횟수로 0이 입력된 경우
			if(tryNumber == 0){
				throw new IllegalArgumentException("게임을 실행할 수 없습니다.");
			}

			// 4. 시도 횟수로 음수가 입력된 경우
			if (tryNumber < 0){
				throw new IllegalArgumentException("시도 횟수는 양수를 입력해주세요.");
			}
		// 5. 시도 횟수로 숫자가 아닌 값이 입력된 경우
		}catch (NumberFormatException e){
			throw new IllegalArgumentException("시도 횟수는 문자를 입력할 수 없습니다.");
		}

		// 1명이 입력된 경우 바로 최종 우승자 출력
		if (cars.size() == 1){
			System.out.println("최종 우승자 : " + cars.get(0));
			return;
		}

		// cars에 이름 저장
		for (String carName : cars) {
			carForward.put(carName, carForward.getOrDefault(carName, ""));
		}

		System.out.println();
		System.out.println("실행 결과");

		for (int i = 0; i < tryNumber; i++) {
			for(String carName : carForward.keySet()){
				if(Randoms.pickNumberInRange(0,9) >= 4){	// 4이상일 경우 전진
					carForward.replace(carName, carForward.get(carName)+"-");
				}

				System.out.println(carName + " : " + carForward.get(carName));
			}

			System.out.println();
		}

		// 7. 시도 횟수로 1이 입력 되었을 때 모든 차가 출발하지 않은 경우
		if(tryNumber == 1 && carForward.values().stream().allMatch(length -> length.equals(""))){
			throw new IllegalArgumentException("전진한 차가 없어서 우승자가 없습니다.");
		}

		// 가장 멀리간 자동차의 길이 구함
		int winnerLength = carForward.values().stream()
			.mapToInt(String::length)
			.max()
			.orElse(0);

		// 최종 우승자를 리스트에 담음
		carForward.entrySet().stream()
			.filter(carName -> carName.getValue().length() == winnerLength)
			.forEach(carName -> winner.add(String.valueOf(carName.getKey())));

		System.out.print("최종 우승자 : ");
		if(winner.size() == 1){	// 우승자가 1명인 경우
			System.out.println(winner.get(0));
			return;
		}
			// 우승자가 여러 명인 경우
			System.out.println(String.join(", ", winner));
	}
}