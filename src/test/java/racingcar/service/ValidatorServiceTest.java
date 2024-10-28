package racingcar.service;

import java.util.HashSet;
import java.util.Set;
import racingcar.domain.enums.ValidationMsg;

public class ValidatorServiceTest {
	private StringUtilService stringUtilService = StringUtilService.getInstance();
	private static final int MAX_CAR_NAME_LENGTH = 5;

	// start: Singleton Holder
	private ValidatorServiceTest() {
	}

	private static class InnerValidatorService {
		private static final ValidatorServiceTest instance = new ValidatorServiceTest();
	}

	public static ValidatorServiceTest getInstance() {
		return InnerValidatorService.instance;
	}
	// end: Singleton Holder

	public boolean isMoreThanTwoCar(String carName) {
		return (stringUtilService.splitByComma(carName).size() >= 2);
	}

	public ValidationMsg validateCarCount(String carName) {
		if (this.isMoreThanTwoCar(carName)) return ValidationMsg.PROPER_TYPE;
		return ValidationMsg.NEED_MORE_THEN_TWO;
	}

	public ValidationMsg validationCarName(String carName) {
		if (carName == null) return ValidationMsg.NULL_TYPE;
		if (carName.isEmpty()) return ValidationMsg.EMPTY_TYPE;
		if (this.isPassCarNameLength(carName) == false) return ValidationMsg.CAR_NAME_OVER_FIVE;
		if (!this.isMoreThanTwoCar(carName)) return ValidationMsg.NEED_MORE_THEN_TWO;
		if (this.isDuplicateUserInput(carName)) return ValidationMsg.NOT_DUPLICATE_NAME;
		return ValidationMsg.PROPER_TYPE;
	}

	private boolean isPassCarNameLength(String carName) {
		for (String eachCar : stringUtilService.splitByComma(carName)) {
			if (eachCar.length() > MAX_CAR_NAME_LENGTH) return false;
		}
		return true;
	}

	// 중복 입력된 값이 있는지 체크
	public boolean isDuplicateUserInput(String userInput) {
		String[] arrUserInput = userInput.split("");
		Set<String> userInputSet = new HashSet<>();
		for (String userInputNum : arrUserInput) {
			userInputSet.add(userInputNum);
		}
		return (arrUserInput.length != userInputSet.size());
	}

	public ValidationMsg validationCarRaceTimes(String RaceTimes) {
		if (RaceTimes == null) return ValidationMsg.NULL_TYPE;
		if (RaceTimes.isEmpty()) return ValidationMsg.EMPTY_TYPE;
		try { Integer.valueOf(RaceTimes); } catch (NumberFormatException e) { return ValidationMsg.NOT_NUMBER; }
		if (RaceTimes.equals("0")) return ValidationMsg.ZERO_TYPE;
		return ValidationMsg.PROPER_TYPE;
	}
}
