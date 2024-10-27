package custom.service;

import custom.validator.InputValidator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {
    private final InputValidator inputValidator;
    private static final String COMMA = ",";

    public CarNameParser() {
        this.inputValidator = new InputValidator();
    }

    public String cleanComma(String input) {
        return input.replaceAll(",+", COMMA).replaceAll("^" + COMMA + "|" + COMMA + "$", "");
    }

    public List<String> splitByComma(String input) {
        return Arrays.asList(input.split(COMMA)); // 쉼표로 분리한 후 리스트로 반환
    }

    public List<String> trimCarNames(List<String> input) {
        return input.stream() // 리스트를 스트림으로 변환
                .map(String::trim) // 각 문자열에 trim() 적용
                .filter(s -> !s.isEmpty()) // 빈 문자열 제외
                .collect(Collectors.toList()); // 리스트로 수집
    }

    public List<String> run(String input) {
        inputValidator.checkCarNamesEmptyInput(input);

        String cleanedCommaString = cleanComma(input);
        List<String> separatedStrings = splitByComma(cleanedCommaString);
        List<String> carList = trimCarNames(separatedStrings);

        inputValidator.checkNumberOfCars(carList);
        inputValidator.validateCarNames(carList);

        return carList;
    }
}