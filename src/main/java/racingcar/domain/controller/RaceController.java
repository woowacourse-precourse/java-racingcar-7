package racingcar.domain.controller;

import java.util.Arrays;

import racingcar.domain.model.CarList;
import racingcar.domain.model.ErrorMessage;
import racingcar.domain.view.RaceView;

public class RaceController {

	private static final String DEFAULT_SEPARATOR = ",";
	private static final String EMPTY_INPUT_REGEX = ".*\\s+.*";
	private static final int MAX_CAR_NAME_LENGTH = 5;

	private final CarList carList;
	private final RaceView raceView;

	public RaceController(CarList carList, RaceView raceView) {
		this.raceView = raceView;
		this.carList = carList;
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
