package racingcar.racinggame.io.input.validation;

import java.util.regex.Pattern;

public class UserInputValidation {

	private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?\\d+$");
	private static final int MIN_TRY_COUNT = 1;
	private static final int MAX_TRY_COUNT = 10_000;
	private static final String BLANK_INPUT_ERROR_MESSAGE = "빈 문자열은 입력할 수 없습니다.";
	private static final String NOT_CONTAIN_CAR_NAME_DELIMITER_ERROR_MESSAGE = "2대 이상의 자동차를 쉼표를 이용해 구분해 입력해주세요";
	private static final String NOT_NUMBER_TYPE_ERROR_MESSAGE = "숫자만 입력 가능합니다.";
	private static final String OVER_FLOW_TRY_COUNT_RANGE = "시도 횟수가 지정된 횟수를 벗어났습니다.";

	public void validateInputCarNames(String inputCarNames, String delimiter) {
		validateBlankInput(inputCarNames);
		validateNotContainsCarNameDelimiter(inputCarNames, delimiter);
	}

	private void validateNotContainsCarNameDelimiter(String userInput, String delimiter) {
		if (!userInput.contains(delimiter)) {
			throw new IllegalArgumentException(NOT_CONTAIN_CAR_NAME_DELIMITER_ERROR_MESSAGE);
		}
	}

	public void validateTryCount(String inputTryCount) {
		validateBlankInput(inputTryCount);
		validateNumberType(inputTryCount);
	}

	private void validateNumberType(String userInput) {
		if (!NUMBER_PATTERN.matcher(userInput).matches()) {
			throw new IllegalArgumentException(NOT_NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	private void validateBlankInput(String userInput) {
		if (userInput.isBlank()) {
			throw new IllegalArgumentException(BLANK_INPUT_ERROR_MESSAGE);
		}
	}

	public void validateTryCountRange(int tryCount) {
		if (tryCount < MIN_TRY_COUNT || MAX_TRY_COUNT < tryCount) {
			throw new IllegalArgumentException(OVER_FLOW_TRY_COUNT_RANGE);
		}
	}

}
