package racingcar.util;

import racingcar.config.GameConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private Validator() {
        // 인스턴스화 방지
    }

    private static void validateCarNameFormat(String name) {
        if (name.startsWith(" ") || name.endsWith(" ")) {
            throw new IllegalArgumentException("차량 이름 앞뒤에 공백이 포함될 수 없습니다.");
        }
    }

    public static void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            // 텍스트를 enum으로 처리하기
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > GameConfig.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + GameConfig.MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    private static void validateCarNamesFormat(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("차량 이름은 비어 있을 수 없습니다.");
        }

        String[] splitNames = input.split(",");
        for (String name : splitNames) {
            validateCarNameFormat(name);
        }
    }

    public static void validateCarNames(List<String> carNames, String input) {
        // 자동차가 한 대일 때 쉼표 검증
        if (carNames.size() == 1 && input.contains(",")) {
            throw new IllegalArgumentException("차량이 한 대일 때 쉼표는 포함될 수 없습니다.");
        }

        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

        for (String name : carNames) {
            validateCarName(name);
        }
        validateCarNamesFormat(input);
    }

    public static void validateTrialNumber(String trialNumber) {
        if (trialNumber == null || trialNumber.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 비어 있을 수 없습니다.");
        }
        
        int trialCount;
        try {
            trialCount = Integer.parseInt(trialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 숫자로 입력해야 합니다.");
        }

        if (trialCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자이여야 합니다.");
        }
    }
}
