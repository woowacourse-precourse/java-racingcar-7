package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static Map<String, Integer> carGameResult;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String countInput = readLine();

        List<String> carNameList = validCarNames(carNames);
        int gameCount = validGameCount(countInput);
        startGame(carNameList, gameCount);
    }

    public static List<String> validCarNames(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
        List<String> carName = List.of(carNames.split(",", -1));
        for (String name : carName) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름을 5자 이하로 적어주세요.");
            }
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
            }
        }
        return carName;
    }

    public static int validGameCount(String gameCount) {
        try {
            int count = Integer.parseInt(gameCount);
            if (count < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public static void startGame(List<String> carNameList, int gameCount) {
        carGameResult = initResult(carNameList);
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            startRound(carNameList);
            printRoundResult();
            System.out.println();
        }
    }

    public static Map<String, Integer> initResult(List<String> carNameList) {
        Map<String, Integer> carGameResult = new LinkedHashMap<>();
        for (String carName : carNameList) {
            carGameResult.put(carName, 0);
        }
        return carGameResult;
    }

    public static void startRound(List<String> carNameList) {
        for (String carName : carNameList) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                carGameResult.put(carName, carGameResult.get(carName) + 1);
            }
        }
    }

    public static void printRoundResult() {
        for (String carName : carGameResult.keySet()) {
            System.out.println(carName + " : " + "-".repeat(carGameResult.get(carName)));
        }
    }

    public static List<String> getWinner() {
        int maxDistance = carGameResult.values().stream()
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new);
        return carGameResult.entrySet().stream()
                .filter(entry -> entry.getValue() == maxDistance)
                .map(Map.Entry::getKey)
                .toList();
    }

}
