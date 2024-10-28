package racingcar.parser;

import java.util.regex.Pattern;

public class CarNameParser implements Parser {

    private final String delimiter;
    private final int nameMinimumLength;
    private final String regularExpression;

    public CarNameParser(ParserConfig config) {
        this.delimiter = config.getDelimiter();
        this.nameMinimumLength = config.getNameMinimumLength();
        this.regularExpression = config.getRegularExpression();
    }

    @Override
    public String[] parse(String input) {
        String[] carNames = input.split(delimiter);
        validate(carNames);
        return carNames;
    }

    private void validate(String[] carNames) {
        validateArrayZeroLength(carNames);
        validateCarNamesCharacters(carNames);
        validateCarNameLength(carNames);
    }

    private void validateArrayZeroLength(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("구분자만 입력할 수 없습니다.");
        }
    }

    private void validateCarNamesCharacters(String[] carNames) {
        for (String carName : carNames) {
            validateCharacter(carName);
        }
    }

    private void validateCharacter(String carName) {
        if (!Pattern.matches(regularExpression, carName)) {
            throw new IllegalArgumentException("사용할 수 없는 자동차 이름입니다.");
        }
    }

    private void validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > nameMinimumLength || carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 0 이상 " + nameMinimumLength + "글자 이하만 가능합니다.");
            }
        }
    }
}
