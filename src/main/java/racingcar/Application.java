package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<String> playGame(List<String> carNames, int numberOfMoves) {
        LinkedHashMap<String, Integer> carDistanceResults = new LinkedHashMap<>();
        List<String> winner = new ArrayList<>();

        //LinkedHashMap 초기화
        for (String carName : carNames) {
            carDistanceResults.put(carName, 0);
        }

        for (int i = 0; i < numberOfMoves; i++) {
            for (String carName : carDistanceResults.keySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                updateDistance(carDistanceResults, carName, randomNumber);
            }
            System.out.println("실행 결과");
            printRoundScores(carDistanceResults);
            System.out.println();
        }

        int maxDistance = carDistanceResults.values().stream()
                .max(Integer::compare)
                .orElse(0);

        //우승자 결정
        for (String carName : carDistanceResults.keySet()) {
            if (carDistanceResults.get(carName) == maxDistance) {
                winner.add(carName);
            }
        }

        return winner;
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
        System.out.println();
    }

    //쉼표가 아닌 구분자 예외처리
    //공백 처리
    public static List<String> splitCarNames(String userInputNames) throws IllegalAccessError {
        List<String> carNames = Arrays.asList(userInputNames.split(","));
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(carName + "은 5글자가 넘습니다.");
            }
        }
        return carNames;
    }
}
