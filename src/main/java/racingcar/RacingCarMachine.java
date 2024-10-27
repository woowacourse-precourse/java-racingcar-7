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
	private List<String> carNames = new ArrayList<>();
	private List<String> winner = new ArrayList<>();
	private int tryNumber;

	public void run() {
		showStartMessage();

		carNames = getUserCarName();

		// 1. 이름 입력 시 이름을 입력하지 않은 경우
		if(doesNotEnterCarName()){
			throw new IllegalArgumentException("이름을 입력해 주세요.");
		}

		// 2. 이름 입력 시 5자 이상인 경우
		isCarNameLengthValid();

		showTryMessage();

		try {
			tryNumber = getUserTryNumber();

			// 6. 시도 횟수로 0이 입력된 경우
			if(isSameTryNumberZero()){
				throw new IllegalArgumentException("게임을 실행할 수 없습니다.");
			}

			// 4. 시도 횟수로 음수가 입력된 경우
			if (doesTryNumberNegative()){
				throw new IllegalArgumentException("시도 횟수는 양수를 입력해주세요.");
			}
		// 5. 시도 횟수로 숫자가 아닌 값이 입력된 경우
		}catch (NumberFormatException e){
			throw new IllegalArgumentException("시도 횟수는 문자를 입력할 수 없습니다.");
		}

		// 1명이 입력된 경우 바로 최종 우승자 출력
		if (hasOnlyOneCar()){
			showOnlyOneInputWinner();
			return;
		}

		// carForward에 이름 저장
		saveCarNamesInCarForward();

		showStartResultMessage();

		excuteGameByTryNumber();

		// 7. 시도 횟수로 1이 입력 되었을 때 모든 차가 출발하지 않은 경우
		if(doseOneTryNumberAndAllCarsNotForward()){
			throw new IllegalArgumentException("전진한 차가 없어서 우승자가 없습니다.");
		}

		// 가장 멀리간 자동차의 길이 구함
		int winnerLength = getWinnerLength();

		// 최종 우승자를 리스트에 담음
		saveWinnerInList(winnerLength);

		showWinner();
	}

	private void isCarNameLengthValid() {
		for (String carName : carNames) {
			if (isCarNameTooLong(carName)){
				throw new IllegalArgumentException("5자 미만의 이름을 입력해 주세요.");
			}
		}
	}

	private void saveWinnerInList(int winnerLength) {
		carForward.entrySet().stream()
			.filter(carName -> carName.getValue().length() == winnerLength)
			.forEach(carName -> winner.add(String.valueOf(carName.getKey())));
	}

	private void saveCarNamesInCarForward() {
		for (String carName : carNames) {
			carForward.put(carName, carForward.getOrDefault(carName, ""));
		}
	}

	private void showWinner() {
		System.out.print("최종 우승자 : ");

		if(winner.size() == 1){	// 우승자가 1명인 경우
			System.out.println(winner.get(0));
			return;
		}
		// 우승자가 여러 명인 경우
		System.out.println(String.join(", ", winner));
	}

	private int getWinnerLength() {
		return carForward.values().stream()
			.mapToInt(String::length)
			.max()
			.orElse(0);
	}

	private boolean doseOneTryNumberAndAllCarsNotForward() {
		return tryNumber == 1 && carForward.values().stream().allMatch(length -> length.equals(""));
	}

	private void excuteGameByTryNumber() {
		for (int i = 0; i < tryNumber; i++) {
			canMoveForward();
			showBlankSpace();
		}
	}

	private void showBlankSpace() {
		System.out.println();
	}

	private void canMoveForward() {
		for(String carName : carForward.keySet()){
			if(Randoms.pickNumberInRange(0,9) >= 4){	// 4이상일 경우 전진
				carForward.replace(carName, carForward.get(carName)+"-");
			}

			System.out.println(carName + " : " + carForward.get(carName));
		}
	}

	private void showStartResultMessage() {
		showBlankSpace();
		System.out.println("실행 결과");
	}

	private void showOnlyOneInputWinner() {
		System.out.println("최종 우승자 : " + carNames.get(0));
	}

	private boolean hasOnlyOneCar() {
		return carNames.size() == 1;
	}

	private boolean doesTryNumberNegative() {
		return tryNumber < 0;
	}

	private boolean isSameTryNumberZero() {
		return tryNumber == 0;
	}

	private int getUserTryNumber() {
		return Integer.parseInt(Console.readLine());
	}

	private void showTryMessage() {
		System.out.println("시도할 횟수는 몇 회인가요?");
	}

	private boolean isCarNameTooLong(String car) {
		return car.length() > 4;
	}

	private boolean doesNotEnterCarName() {
		return carNames.get(0).equals("");
	}

	private List<String> getUserCarName() {
		return Arrays.asList(Console.readLine().trim().split(","));
	}

	private void showStartMessage() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}
}