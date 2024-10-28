package racingcar;

import java.util.HashSet;
import java.util.Set;

public class InputHandler {

    public String[] InputCarNames(String input) {
        String[] names;

        if (isCorrectDelimiter(input)) {
            names = processCarNames(input);
        } else {
            throw new IllegalArgumentException("쉼표(,)로 자동차 이름을 구분해주세요.");
        }

        return names;
    }

    private Boolean isCorrectDelimiter(String input) {
        return input.contains(",");
    }

    private String[] processCarNames(String input) {
        String[] names = input.split(",");
        Set<String> nameSet = new HashSet<>();

        for (int idx = 0; idx < names.length; ++idx) {
            names[idx] = names[idx].trim();

            if (names[idx].isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
            } else if (names[idx].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            } else if (!nameSet.add(names[idx])) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }

        return names;
    }
    
    public int GetRound(String input) {
        try {
            int rounds = Integer.parseInt(input);
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }
}


