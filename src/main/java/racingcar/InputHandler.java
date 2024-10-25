package racingcar;

import java.util.HashSet;
import java.util.Set;

public class InputHandler {
    private final String input;
    private String[] names;

    public InputHandler(String input) {
        this.input = input;
    }

    public String[] InputCarName() {
        if (isCorrectDelimiter()) {
            isAcceptableName();
        } else {
            throw new IllegalArgumentException("쉼표(,)로 자동차 이름을 구분해주세요.");
        }

        return names;
    }

    private Boolean isCorrectDelimiter() {
        String delimiter = ",";
        if (input.contains(delimiter)) {
            names = input.split(delimiter);
            return true;
        }
        return false;
    }

    private void isAcceptableName() {
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
    }
}
