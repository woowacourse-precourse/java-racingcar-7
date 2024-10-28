package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationCheck {
    private static Pattern pattern = Pattern.compile("[A-Za-z][A-Za-z0-9]{0,4}");

    public void validateCarName(String carName) {
        isNullOrEmptyName(carName);
        hasMoreThanFiveCharacters(carName);
        hasDuplicateNames(carName);
        endsWithComma(carName);
    }

    private void isNullOrEmptyName(String carName) {
        if (carName == null || carName.isBlank() || carName.isEmpty())
            throw new IllegalArgumentException("입력값이 없습니다.");
    }

    private void hasMoreThanFiveCharacters(String carName) {
        for (String car : carName.split(",")) {
            Matcher matcher = pattern.matcher(car);
            if (matcher.matches() == false)
                throw new IllegalArgumentException("이름이 다섯글자가 넘거나 이름에 허용되지 않는 특수문자가 있습니다.");
        }
    }

    private void hasDuplicateNames(String carName) {
        String[] splitCarName = carName.split(",");
        Set<String> carNameSet = new HashSet<>(Arrays.asList(splitCarName));
        ArrayList<String> carNameArray = new ArrayList<>(Arrays.asList(splitCarName));
        if (carNameSet.size() != carNameArray.size())
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
    }


    private void endsWithComma(String carName) {
        if (carName.endsWith(",")) {
            throw new IllegalArgumentException("구분자 뒤에 자동차 이름을 입력하세요.");
        }
    }

    public void validateNumberOfTrial(String numberOfTrial) {
        isNullOrEmptyNumber(numberOfTrial);
        hasNumberFormatException(numberOfTrial);
        isNegativeTrial(numberOfTrial);
    }

    private void isNullOrEmptyNumber(String numberOfTrial) {
        if (numberOfTrial.isEmpty() || numberOfTrial.isBlank())
            throw new IllegalArgumentException("시도횟수가 올바르지 않습니다.");
    }

    private void hasNumberFormatException(String numberOfTrial) {
        try {
            int intNumberOfTrial = Integer.parseInt(numberOfTrial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 올바르지 않습니다.");
        }
    }

    private void isNegativeTrial(String numberOfTrial) {
        if (Integer.parseInt(numberOfTrial) <= 0) {
            throw new IllegalArgumentException("최소 한 번의 시도를 해야합니다.");
        }
    }

}
