package racingcar;

import java.util.regex.Pattern;

public class ValidationCheck {
    private static Pattern pattern = Pattern.compile("[A-Za-z][A-Za-z0-9]{0,4}");

    public void validateCarName(String carName){
        isNullOrEmptyName(carName);
        hasDuplicateNames(carName);
        hasMoreThanFiveCharacters(carName);
        endsWithComma(carName);
    }
    public void validateNumberOfTrial(String numberOfTrial){
        hasNumberFormatException(numberOfTrial);
        isNegetiveTrial(numberOfTrial);
        isNullOrEmptyNumber(numberOfTrial);
    }
}
