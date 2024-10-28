package racingcar.validator;

public interface Validator {
	static Validator getInstance() {
		return new ValidatorImpl();
	}
	
	String[] stringToArray(final String inputRacingCarNames);
	long stringToLong(final String inputTryingCount);
}
