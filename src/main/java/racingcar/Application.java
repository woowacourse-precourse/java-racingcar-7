package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Application {
    static String INVAILD_INPUT_MESSAGE = "잘못된 입력입니다. ";
    static List<String> carNames = new ArrayList<>();
    static int attemptCount;
    static Map<String, Integer> racingResult = new HashMap<>();

    public static void main(String[] args) {
        input();

        for (int i = 0; i < attemptCount; i++) {
            carRacing(carNames);
        }
    }

    private static void input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNamesInput = List.of(Console.readLine().trim().split(","));
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptCountInput = Console.readLine();

        validateCarNamesAndAddToList(carNamesInput);
        attemptCount = validateAttemptConunt(attemptCountInput);
    }

    private static int validateAttemptConunt(String attemptCountInput) {
        int attemptCount;

        if (attemptCountInput == null) {
            throw new IllegalArgumentException(INVAILD_INPUT_MESSAGE);
        }
        try {
            attemptCount = Integer.parseInt(attemptCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVAILD_INPUT_MESSAGE);
        }

        return attemptCount;
    }

    private static void validateCarNamesAndAddToList(List<String> carNamesInput) {
        String patternStr = "^[0-9a-zA-Z]*$";

        for (String carNameInput : carNamesInput) {
            if (Pattern.matches(patternStr, carNameInput) && //자동차 이름이 알파벳과 숫자로만 이루어짐
                    carNameInput.length() < 5 && //자동차 이름의 길이가 5 이하
                    carNameInput != null) { //자동차 이름이 빈 값이 아님

                carNames.add(carNameInput);
            } else {
                throw new IllegalArgumentException(INVAILD_INPUT_MESSAGE);
            }
        }
    }

    private static void carRacing(List<String> carNames) {
        List<Integer> scores = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < carNames.size(); i++) {
            int score = randomScore();
            scores.add(score);
            max = Math.max(max, score);
        }

        //racingOutput(scores);
        //getWinner(scores, max);
    }

    private static Integer randomScore() {
        int score = Randoms.pickNumberInRange(0, 9);
        if (score >= 4) {
            return score;
        } else {
            return 0;
        }
    }
}
