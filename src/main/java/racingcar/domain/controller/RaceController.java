package racingcar.domain.controller;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.model.Car;
import racingcar.domain.model.CarList;
import racingcar.domain.model.ErrorMessage;
import racingcar.domain.view.RaceView;

public class RaceController {
	private static final int MIN_PICK_NUMBER = 0;
	private static final int MAX_PICK_NUMBER = 9;
	private static final String DEFAULT_SEPARATOR = ",";
	private static final String EMPTY_INPUT_REGEX = ".*\\s+.*";
	private static final int MAX_CAR_NAME_LENGTH = 5;

	private final CarList carList;
	private final RaceView raceView;

	public RaceController(CarList carList, RaceView raceView) {
		this.raceView = raceView;
		this.carList = carList;
	}

	public void run() {
		receiveCarNames();
		int lap = receiveRaceLap();
		for (int i = 0; i < lap; ++i) {
			getLapResult();
		}
		getWinner();
	}

	public void receiveCarNames() {
		String input = raceView.receiveCarNames();
		validateInput(input);

		String[] names = splitInput(input);
		validateNames(names);

		carList.addCars(names);
	}

	public int receiveRaceLap() {
		int lap = raceView.receiveRaceLap();
		validLapCount(lap);

		return lap;
	}

	private void getLapResult() {
		for (int i = 0; i < carList.getCount(); ++i) {
			Car car = carList.getCar(i);
			moveForwardTargetCar(car);
		}
	}

	private int pickNumberInRange() {
		return Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
	}

	private void moveForwardTargetCar(Car car) {
		car.moveForward(pickNumberInRange());
	}

	private String getWinner() {
		return carList.getWinner().orElse("");
	}

	private void validateInput(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.STRING_EMPTY_ERROR.getMessage());
		}
	}

	private void validateNames(String[] names) {
		if (names.length == 0) {
			throw new IllegalArgumentException(ErrorMessage.CAR_LIST_EMPTY_ERROR.getMessage());
		}

		if (hasInvalidName(names)) {
			throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
		}
	}

	private void validLapCount(int lap) {
		if (lap <= 0) {
			throw new IllegalArgumentException(ErrorMessage.LAP_COUNT_ERROR.getMessage());
		}
	}

	private String[] splitInput(String input) {
		return input.split(DEFAULT_SEPARATOR);
	}

	private boolean isInvalidName(String name) {
		return name.isEmpty() || name.length() > MAX_CAR_NAME_LENGTH || name.matches(EMPTY_INPUT_REGEX);
	}

	private boolean hasInvalidName(String[] names) {
		return Arrays.stream(names).anyMatch(this::isInvalidName);
	}

}
