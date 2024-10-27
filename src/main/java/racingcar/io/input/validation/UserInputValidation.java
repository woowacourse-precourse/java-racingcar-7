package racingcar.io.input.validation;

import java.util.regex.Pattern;

public class UserInputValidation {

	private static final String CAR_NAME_DELIMITER = ",";
	private static final String BLANK_INPUT_ERROR_MESSAGE = "빈 문자열은 입력할 수 없습니다.";
	private static final String NOT_CONTAIN_CAR_NAME_DELIMITER_ERROR_MESSAGE = "2대 이상의 자동차를 쉼표를 이용해 구분해 입력해주세요";

	public void validateInputCarNames(String inputCarNames) {
		validateBlankInput(inputCarNames);
		validateNotContainsCarNameDelimiter(inputCarNames);
	}

	private void validateBlankInput(String userInput) {
		if(userInput.isBlank()) {
			throw new IllegalArgumentException(BLANK_INPUT_ERROR_MESSAGE);
		}
	}

	private void validateNotContainsCarNameDelimiter(String userInput) {
		if(!userInput.contains(CAR_NAME_DELIMITER)) {
			throw new IllegalArgumentException(NOT_CONTAIN_CAR_NAME_DELIMITER_ERROR_MESSAGE);
		}
	}

}
