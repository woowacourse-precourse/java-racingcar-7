package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.CarName;
import racingcar.domain.TryNumber;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class RacingCarMachine {

	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final Map<String, String> carForward = new LinkedHashMap<>();
	private CarName carName;
	private final List<String> winner = new ArrayList<>();
	private TryNumber tryNumber;

	public RacingCarMachine(OutputHandler outputHandler, InputHandler inputHandler) {
		this.outputHandler = outputHandler;
		this.inputHandler = inputHandler;
	}

	public void run() {
		outputHandler.showStartMessage();

		carName = initializeCarName();

		// 1. 이름 입력 시 이름을 입력하지 않은 경우
		if (carName.doesNotEnterCarName()) {
			throw new IllegalArgumentException("이름을 입력해 주세요.");
		}

		// 2. 이름 입력 시 5자 이상인 경우
		carName.isCarNameLengthValid();

		outputHandler.showTryMessage();

		try {
			tryNumber = initializeTryNumber();

			// 6. 시도 횟수로 0이 입력된 경우
			if (tryNumber.isSameTryNumberZero()) {
				throw new IllegalArgumentException("게임을 실행할 수 없습니다.");
			}

			// 4. 시도 횟수로 음수가 입력된 경우
			if (tryNumber.doesTryNumberNegative()) {
				throw new IllegalArgumentException("시도 횟수는 양수를 입력해주세요.");
			}
			// 5. 시도 횟수로 숫자가 아닌 값이 입력된 경우
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도 횟수는 문자를 입력할 수 없습니다.");
		}

		// 1명이 입력된 경우 바로 최종 우승자 출력
		if (carName.hasOnlyOneCar()) {
			outputHandler.showOnlyOneInputWinner(carName.getCarNames());
			return;
		}

		// carForward에 이름 저장
		saveCarNamesInCarForward();

		outputHandler.showStartResultMessage();

		excuteGameByTryNumber();

		// 7. 시도 횟수로 1이 입력 되었을 때 모든 차가 출발하지 않은 경우
		if (doseOneTryNumberAndAllCarsNotForward()) {
			throw new IllegalArgumentException("전진한 차가 없어서 우승자가 없습니다.");
		}

		// 가장 멀리간 자동차의 길이 구함
		int winnerLength = getWinnerLength();

		// 최종 우승자를 리스트에 담음
		saveWinnerInList(winnerLength);

		outputHandler.showWinner(winner);
	}

	private TryNumber initializeTryNumber() {
		return TryNumber.from(inputHandler.getUserTryNumber());
	}

	private CarName initializeCarName() {
		return CarName.from(inputHandler.getUserCarName());
	}

	private void saveWinnerInList(int winnerLength) {
		carForward.entrySet().stream()
			.filter(carName -> carName.getValue().length() == winnerLength)
			.forEach(carName -> winner.add(String.valueOf(carName.getKey())));
	}

	private void saveCarNamesInCarForward() {
		for (String car : carName.getCarNames()) {
			carForward.put(car, carForward.getOrDefault(car, ""));
		}
	}

	private int getWinnerLength() {
		return carForward.values().stream()
			.mapToInt(String::length)
			.max()
			.orElse(0);
	}

	private boolean doseOneTryNumberAndAllCarsNotForward() {
		return tryNumber.getTryNumber() == 1 && carForward.values().stream().allMatch(length -> length.equals(""));
	}

	private void excuteGameByTryNumber() {
		for (int i = 0; i < tryNumber.getTryNumber(); i++) {
			canMoveForward();
			outputHandler.showBlankSpace();
		}
	}

	private void canMoveForward() {
		for (String car : carForward.keySet()) {
			if (Randoms.pickNumberInRange(0, 9) >= 4) {    // 4이상일 경우 전진
				carForward.replace(car, carForward.get(car) + "-");
			}

			outputHandler.showMovementStatus(car, carForward);
		}
	}
}