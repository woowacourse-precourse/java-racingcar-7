package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGame {

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawCarNames = Console.readLine();
        String[] carNames = splitCarNames(rawCarNames);
        validateCarNames(carNames);
        Map<String, Integer> carDistanceMap = carNamesToMap(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryTime = Console.readLine();
        int tryTimeInt = parseAndValidateTryTime(tryTime);

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryTimeInt; i++) {
            moveCars(carDistanceMap);
            printCarDistances(carDistanceMap);
            System.out.println();
        }

        List<String> winners = getWinner(carDistanceMap);
        printWinners(winners);
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }

    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private Map<String, Integer> carNamesToMap(String[] carNameArray) {
        Map<String, Integer> carMap = new HashMap<>();
        for (String carName : carNameArray) {
            carMap.put(carName, 0);
        }
        return carMap;
    }

    private int parseAndValidateTryTime(String tryTime) {
        try {
            int tryTimeInt = Integer.parseInt(tryTime);
            if (tryTimeInt < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상만 가능합니다.");
            }
            return tryTimeInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }
    }

    private void moveCars(Map<String, Integer> carDistanceMap) {
        for (String carName : carDistanceMap.keySet()) {
            int number = getRandomNumber();
            if (isMove(number)) {
                int distance = carDistanceMap.get(carName);
                carDistanceMap.put(carName, distance + 1);
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isMove(int number) {
        return number >= 4;
    }

    private void printCarDistances(Map<String, Integer> carDistanceMap) {
        for (String carName : carDistanceMap.keySet()) {
            System.out.println(carName + " : " + "-".repeat(carDistanceMap.get(carName)));
        }
    }

    private List<String> getWinner(Map<String, Integer> carDistanceMap) {
        int maxDistance = carDistanceMap.values().stream().max(Integer::compareTo).orElseThrow();
        return carDistanceMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxDistance)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }
}
