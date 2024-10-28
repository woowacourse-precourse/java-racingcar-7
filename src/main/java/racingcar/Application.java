package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    //쉼표가 아닌 구분자 예외처리
    public static void main(String[] args) {
        //변수 초기화
        String inputCarNames;
        int NumberOfRounds;
        List<String> carNames;
        List<String> winners;

        //사용자 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputNumber = Console.readLine();

        //사용자 입력 검증
        validateInput(inputCarNames, inputNumber);

        carNames = splitCarNames(inputCarNames);
        NumberOfRounds = Integer.parseInt(inputNumber);

        winners = playGame(carNames, NumberOfRounds);

        printWinner(winners);
    }

    public static void validateInput(String inputCarName, String inputNumber) throws IllegalArgumentException {
        //사용자 입력 값 검증
        if (inputNumber == null || inputNumber.isEmpty() || !inputNumber.matches("\\d+")) {
            throw new IllegalArgumentException("반복 횟수 " + inputNumber + " 은(는) 숫자만 입력 가능합니다.");
        }
        if (inputCarName == null || inputCarName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력 해야 합니다.");
        }
    }

    public static List<String> playGame(List<String> carNames, int numberOfMoves) {
        LinkedHashMap<String, Integer> carDistanceResults = new LinkedHashMap<>();
        List<String> winners = new ArrayList<>();

        //LinkedHashMap 초기화
        for (String carName : carNames) {
            carDistanceResults.put(carName, 0);
        }

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfMoves; i++) {
            for (String carName : carDistanceResults.keySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                updateDistance(carDistanceResults, carName, randomNumber);
            }
            printRoundScores(carDistanceResults);
            System.out.println();
        }

        int maxDistance = carDistanceResults.values().stream()
                .max(Integer::compare)
                .orElse(0);

        //우승자 결정
        for (String carName : carDistanceResults.keySet()) {
            if (carDistanceResults.get(carName) == maxDistance) {
                winners.add(carName);
            }
        }

        return winners;
    }

    public static void updateDistance(LinkedHashMap<String, Integer> carDistanceResults, String carName, int randomNumber) {
        if (randomNumber >= 4) {
            carDistanceResults.replace(carName, carDistanceResults.get(carName) + 1);
        }
    }

    public static void printRoundScores(LinkedHashMap<String, Integer> carDistanceResults) {
        for (String carName : carDistanceResults.keySet()) {
            System.out.printf("%s : %s\n", carName, "-".repeat(carDistanceResults.get(carName)));
        }
    }


    public static List<String> splitCarNames(String userInputNames) throws IllegalAccessError {
        List<String> carNames = Arrays.stream(userInputNames.split(","))
                .map(String::trim)
                .toList();

        HashSet<String> uniqueNames = new HashSet<>();

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(carName + "은(는) 5글자가 넘습니다.");
            } else if (!uniqueNames.add(carName)) {
                throw new IllegalArgumentException(carName + "은(는) 중복된 이름입니다.");
            }
        }
        return carNames;
    }

    public static void printWinner(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
