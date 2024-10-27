package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Application {
    static String INVALID_INPUT_MESSAGE = "잘못된 입력입니다. ";
    static List<String> carNameList = new ArrayList<>();
    static int attemptCount;
    static Map<String, Integer> carWinCounts = new HashMap<>();

    public static void main(String[] args) {
        inputAndValidate();

        System.out.println("\n실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            carRacing(carNameList);
        }

        int maxWinCount = getMaxWinCount();
        List<String> winners = getFinalWinners(maxWinCount);
        printFinalWinners(winners);
    }

    public static void inputAndValidate() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameListInput = List.of(Console.readLine().replaceAll(" ", "").split(","));
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptCountInput = Console.readLine();

        validatecarNameListAndAddToList(carNameListInput);
        attemptCount = validateAttemptConunt(attemptCountInput);
    }

    private static int validateAttemptConunt(String attemptCountInput) {
        int attemptCount;

        if (attemptCountInput == null || attemptCountInput.isEmpty() ||
                attemptCountInput.equals("0") || attemptCountInput.contains(" ") ||
                attemptCountInput.contains("-")) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        try {
            attemptCount = Integer.parseInt(attemptCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        return attemptCount;
    }

    private static void validatecarNameListAndAddToList(List<String> carNameListInput) {
        final String patternStr = "^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]*$";

        for (String carNameInput : carNameListInput) {
            if (Pattern.matches(patternStr, carNameInput) &&
                    carNameInput.length() < 5 &&
                    carNameInput != null && !carNameInput.isEmpty() &&
                    !carNameList.contains(carNameInput)) {

                carNameList.add(carNameInput);
            } else if (carNameList.contains(carNameInput)) {
                continue;
            } else {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
        }
    }

    public static void carRacing(List<String> carNameList) {
        List<Integer> scores = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < carNameList.size(); i++) {
            int score = randomScore();
            scores.add(score);
            max = Math.max(max, score);
        }

        printRacingOutput(scores);
        System.out.println();
        recordWinners(scores, max);
    }

    private static Integer randomScore() {
        int score = Randoms.pickNumberInRange(0, 9);
        if (score >= 4) {
            return score;
        } else {
            return 0;
        }
    }

    private static void printRacingOutput(List<Integer> scores) {
        for (int i = 0; i < scores.size(); i++) {
            System.out.print(carNameList.get(i) + " : ");
            System.out.println("-".repeat(Math.max(0, scores.get(i))));
        }
    }

    private static void recordWinners(List<Integer> scores, int max) {
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) == max) {
                carWinCounts.put(carNameList.get(i), carWinCounts.getOrDefault(carNameList.get(i), 0) + 1);
            }
        }
    }

    private static int getMaxWinCount() {

        List<String> keySet = new ArrayList<>(carWinCounts.keySet());
        //우승 회수 내림차순 정렬
        keySet.sort((o1, o2) -> carWinCounts.get(o2).compareTo(carWinCounts.get(o1)));
        return carWinCounts.get(keySet.get(0));
    }

    private static List<String> getFinalWinners(int maxWinCount) {
        List<String> keySet = new ArrayList<>(carWinCounts.keySet());
        List<String> winners = new ArrayList<>();

        for (String key : keySet) {
            if (carWinCounts.get(key) == maxWinCount) {
                winners.add(key);
            }
        }

        return winners;
    }

    private static void printFinalWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
