package racingcar.controller;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static void lenValidate(String[] carNames,String input) {
        nameNullValidate(carNames, input);
        for (String carName : carNames) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름 길이가 5이상입니다.");
            }
        }
        validateDuplicationName(carNames);
    }

    private static void nameNullValidate(String[] carNames, String input) {
        int commaCount = input.length() - input.replace(",","").length();
        if(commaCount != carNames.length - 1) {
            throw new IllegalArgumentException("쉽표가 이중 이상으로 찍힌 부분이 있습니다.");
        }
        if(carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름 입력값이 비어 있습니다.");
        }
    }

    private static void validateDuplicationName(String[] carName) {
        Set<String> nameSet = new HashSet<>();
        for (String name : carName) {
            if(!nameSet.add(name)){
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
            }
        }
    }

    public static void nullValidate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있거나 null입니다.");
        }
    }

    public static void attemptsValidate(int attempts) {
        if(attempts < 0) {
            throw new IllegalArgumentException("시도 횟수는 양수를 입력해야 합니다.");
        }
    }
}