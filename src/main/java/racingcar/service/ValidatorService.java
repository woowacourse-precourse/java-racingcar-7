package racingcar.service;

import java.util.HashSet;
import java.util.Set;
import racingcar.domain.enums.ValidationMsg;

public class ValidatorService {
	private StringUtilService stringUtilService = StringUtilService.getInstance();
	private static final int MAX_CAR_NAME_LENGTH = 5;
	// start: Singleton Holder
	private ValidatorService() {
	}

	private static class InnerValidatorService {
		private static final ValidatorService instance = new ValidatorService();
	}

	public static ValidatorService getInstance() {
		return InnerValidatorService.instance;
	}
	// end: Singleton Holder

	public boolean isMoreThanTwoCar(String carName) {
		return (stringUtilService.splitByComma(carName).size() >= 2);
	}

	public ValidationMsg validateCarCount(String carName) {
		if (isMoreThanTwoCar(carName)) return ValidationMsg.PROPER_TYPE;
		return ValidationMsg.NEED_MORE_THEN_TWO;
	}

	public ValidationMsg validateCarName(String carName) {
		if (carName == null) return ValidationMsg.NULL_TYPE;
		if (carName.isEmpty()) return ValidationMsg.EMPTY_TYPE;
		if (!isPassCarNameLength(carName)) return ValidationMsg.CAR_NAME_OVER_FIVE;
		if (!isMoreThanTwoCar(carName)) return ValidationMsg.NEED_MORE_THEN_TWO;
		if (isDuplicateUserInput(carName)) return ValidationMsg.NOT_DUPLICATE_NAME;
		return ValidationMsg.PROPER_TYPE;
	}

	private boolean isPassCarNameLength(String carName) {
		for (String eachCar : stringUtilService.splitByComma(carName)) {
			if (eachCar.length() > MAX_CAR_NAME_LENGTH) return false;
		}
		return true;
	}

	public boolean isDuplicateUserInput(String userInput) {
		String[] arrUserInput = userInput.split(",");
		Set<String> userInputSet = new HashSet<>();
		for (String userInputNum : arrUserInput) {
			userInputSet.add(userInputNum);
		}
		return (arrUserInput.length != userInputSet.size());
	}
}
