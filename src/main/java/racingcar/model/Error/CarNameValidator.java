package racingcar.model.Error;

import racingcar.model.Util.Parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.model.Error.ErrorMessage.*;

public class CarNameValidator extends Validator {
    private final Parser parser;
    private static int CAR_NAME_MAX = 5;

    @Override
    protected void validateInputMustHaveValue(Object input) {
        if (!(input instanceof List<?>)) {
            throw new IllegalArgumentException(NotValidType);
        }

        List<?> listInput = (List<?>) input;
        for (Object element : listInput) {
            if (element instanceof String && ((String) element).isBlank()) {
                throw new IllegalArgumentException(InputMustHaveValue);
            }
        }
    }

    public CarNameValidator(Parser parser) {
        this.parser = parser;
    }

    public List<String> validateCarName(String input) {
        List<String> carNames;
        carNames = parser.inputParser(input);

        validateAllCase(input, carNames);
        return carNames;
    }

    private void validateAllCase(String input, List<String> carNames) {
        validateInputMustHaveValue(carNames);
        validateNotAllowedDelimiter(input);
        validateInputIsDuplicate(carNames);
        validateCarNameMaxIs5Length(carNames);
    }

    private void validateInputIsDuplicate(List<String>carNames) {
        Set<String> CarNameDuplicateCheck = new HashSet<>(carNames);

        if(CarNameDuplicateCheck.size()<carNames.size()){
            throw new IllegalArgumentException(CarNameMustBeUnique);
        }
    }

    private void validateCarNameMaxIs5Length(List<String>carNames){
        for(String name : carNames){
            if(name.length()>CAR_NAME_MAX){
                throw new IllegalArgumentException(CarNameMaxis5Length);
            }
        }
    }

    private void validateNotAllowedDelimiter(String input) {
        String notAllowedDelimiterPattern = "[^\\w,]"; // 알파벳, 숫자, 쉼표를 제외한 모든 문자

        if (input.matches(".*" + notAllowedDelimiterPattern + ".*")) {
            throw new IllegalArgumentException(NotAllowedDelimiter);
        }
    }

}
