package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateEmptyRacingCarNames(String racingCarNames) {
        if (racingCarNames == null || racingCarNames.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차의 이름을 입력하지 않았습니다.");
        }
    }

    public void validateEmptyRacingCount(String racingCount) {
        if (racingCount == null || racingCount.isEmpty()) {
            throw new IllegalArgumentException("경주 횟수를 입력하지 않았습니다.");
        }
    }

    public void validateInvalidRacingCount(String racingCount) {
        try {
            Integer.parseInt(racingCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(racingCount + ": 숫자만 입력할 수 있습니다.");
        }
    }

    public void validateWhitespaceOrEmptyInCarNames(String racingCarNames) {
        if (racingCarNames == null || racingCarNames.isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    public void validateCarNameLength(String racingCarNames) {
        if (racingCarNames.length() > 5) {
            throw new IllegalArgumentException(racingCarNames + ": 이름은 5자를 초과할 수 없습니다");
        }
    }

    public void validateDuplicateRacingCarNames(List<String> racingCarNamesList) {
        Set<String> racingCarNameSet = new HashSet<>();

        for (String racingCarName : racingCarNamesList) {
            validateDuplicateName(racingCarNameSet, racingCarName);
        }
    }

    private void validateDuplicateName(Set<String> racingCarNameSet, String racingCarName) {
        if (!racingCarNameSet.add(racingCarName)) {
            throw new IllegalArgumentException(racingCarName + ": 중복된 이름이 입력되었습니다.");
        }
    }

    public void checkHasWinners(int maxScore, Set<String> winnerName) {
        if (maxScore == 0 || winnerName.isEmpty()) {
            throw new IllegalArgumentException("우승자가 존재하지 않습니다. 다시 레이싱을 진행해주세요");
        }
    }
}
