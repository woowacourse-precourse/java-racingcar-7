package racingcar;

import java.util.List;
import java.util.StringTokenizer;

public class Validator {
    private final int LENGTH_LIMIT = 5;

    public void carNamesValidation(String carNames) {
        isInputEmpty(carNames);
        isContainsWhitespace(carNames);
        isCarNameEmpty(carNames);
        isLengthExceeded(carNames);
        isDuplicate(carNames);
    }

    public void attemptsNumberValidation(String attemptsNumber) {
        isInputEmpty(attemptsNumber);
        isInteger(attemptsNumber);
        isPositive(attemptsNumber);
    }

    public void isInputEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }
    }

    public void isContainsWhitespace(String carNames) {
        if (carNames.contains(" ")) throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public void isCarNameEmpty(String carNames) {
        if (carNames.contains(",,")) throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public void isLengthExceeded(String carNames) {
        StringTokenizer carNameToken = new StringTokenizer(carNames, ",");
        while (carNameToken.hasMoreTokens()) {
            if (carNameToken.nextToken().length() > LENGTH_LIMIT) {
                throw new IllegalArgumentException("자동치 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void isDuplicate(String carNames) {
        CarFactory carFactory = new CarFactory();
        List<String> cars = carFactory.createCarNameList(carNames);
        List<String> distinctCars = cars.stream().distinct().toList();
        if (cars.size() != distinctCars.size()) {
            throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
        }
    }

    public void isInteger(String attemptsNumber) {
        try {
            Integer.parseInt(attemptsNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }
    }

    public void isPositive(String attemptsNumber) {
        if (Integer.parseInt(attemptsNumber) <= 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }
}
