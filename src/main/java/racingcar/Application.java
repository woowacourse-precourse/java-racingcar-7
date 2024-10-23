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
    static Map<String, Integer> racingWin = new HashMap<>();

    public static void main(String[] args) {
        input();

        System.out.println("\n실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            carRacing(carNames);
        }

        int maxWinCount = getWinCount();
        List<String> winners = getFinalWinners(maxWinCount);
        printFinalWinners(winners);
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

        racingOutput(scores);
        System.out.println();
        getWinner(scores, max);
    }

    private static Integer randomScore() {
        int score = Randoms.pickNumberInRange(0, 9);
        if (score >= 4) {
            return score;
        } else {
            return 0;
        }
    }

    private static void racingOutput(List<Integer> scores) {
        for (int i = 0; i < scores.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            scoreOutput(scores.get(i));
        }
    }

    private static void scoreOutput(int score) {
        for (int i = 0; i < score; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void getWinner(List<Integer> scores, int max) {
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) == max) {
                racingWin.put(carNames.get(i), racingWin.getOrDefault(carNames.get(i), 0) + 1);
            }
        }
    }

    private static int getWinCount() {

        List<String> keySet = new ArrayList<>(racingWin.keySet());
        //우승 회수 내림차순 정렬
        keySet.sort((o1, o2) -> racingWin.get(o2).compareTo(racingWin.get(o1)));
        return racingWin.get(keySet.get(0));
    }

    private static List<String> getFinalWinners(int maxWinCount) {
        List<String> keySet = new ArrayList<>(racingWin.keySet());
        List<String> winners = new ArrayList<>();

        for (String key : keySet) {
            if (racingWin.get(key) == maxWinCount) {
                winners.add(key);
            }
        }

        return winners;
    }

    private static void printFinalWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.println(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
