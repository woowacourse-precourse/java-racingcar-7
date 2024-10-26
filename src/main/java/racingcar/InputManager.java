package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputManager {
    public static List<String> getRacerNames() {
        String input = Console.readLine();
        checkInput(input);
        String[] racerNames = input.split(",");
        return Arrays.stream(racerNames)
                .filter(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("입력된 이름이 5자를 초과합니다.");
                    }
                    return true;
                })
                .toList();
    }

    public static int getTrialCount() {
        String input = Console.readLine();
        checkInput(input);
        try {
            int rawNumber = Integer.parseInt(input);
            if (rawNumber <= 0) {
                throw new IllegalArgumentException("횟수를 0 또는 음수로 입력할 수 없습니다.");
            }
            return rawNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수 입력이 잘못되었습니다.");
        }
    }

    private static void checkInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }
}
