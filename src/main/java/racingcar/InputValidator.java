package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public List<String> validateCarNames(String carNamesInput) {

        if (carNamesInput == null || carNamesInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 입력이 비어있습니다.");
        }
        if (carNamesInput.endsWith(",")) {
            throw new IllegalArgumentException("자동차 이름은 콤마(,)로 끝날 수 없습니다.");
        }
        for (char c : carNamesInput.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == ',' || Character.isWhitespace(c))) {
                throw new IllegalArgumentException("자동차 이름은 영어와 숫자만 포함할 수 있으며, 쉼표(,)로 구분해야 합니다.");
            }
        }

        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        Set<String> uniqueNames = new HashSet<>();

        for (String name : carNames) {
            String trimmedName = name.trim();

            // 공백 여부 확인
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }

            // 이름 중복 확인
            if (!uniqueNames.add(trimmedName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }

            // 이름 길이 확인
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        // 최소 자동차 개수 확인
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
        }

        return carNames;
    }

    public void validateRounds(String roundsInput) {
        if (roundsInput == null || roundsInput.trim().isEmpty()) {
            throw new IllegalArgumentException("시도할 횟수 입력이 비어있습니다.");
        }
        try {
            int rounds = Integer.parseInt(roundsInput);

            if (rounds < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 하며, int 범위를 초과할 수 없습니다.", e);
        }
    }

}
