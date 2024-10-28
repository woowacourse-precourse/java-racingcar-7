package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameConfigParser {
    public static List<String> parseCarNames(String input) {
        String [] splited = input.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : splited) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름으로 공백은 허용되지 않습니다.");
            }
            carNames.add(name);
        }
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("반드시 하나 이상의 자동차 이름이 필요합니다.");
        }
        return carNames;
    }

    public static int parseNumberOfTurn(String input) {
        int numberOfTurn = Integer.parseInt(input);
        if (numberOfTurn < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수여선 안됩니다.");
        }
        return numberOfTurn;
    }
}
