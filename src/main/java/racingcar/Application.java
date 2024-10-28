package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Application {
    //쉼표가 아닌 구분자 예외처리
    public static void main(String[] args) {
        //변수 초기화
        String inputCarNames;
        int NumberOfRounds;
        List<String> carNames;
        List<String> winner;

        //사용자 입력
        inputCarNames = Console.readLine();
        String inputNumber = Console.readLine();

        //사용자 입력 검증
        validateInput(inputCarNames, inputNumber);

        carNames = splitCarNames(inputCarNames);
        NumberOfRounds = Integer.parseInt(inputNumber);

        winner = playGame(carNames, NumberOfRounds);
    }

    public static void validateInput(String inputCarName, String inputNumber) throws IllegalArgumentException {
        //사용자 입력 값 검증
        if (inputNumber == null || inputNumber.isEmpty() || !inputNumber.matches("\\d+")) {
            throw new IllegalArgumentException("반복 횟수 " + inputNumber + " 는 숫자만 입력 가능합니다.");
        }
        if (inputCarName == null || inputCarName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력 해야 합니다.");
        }
    }

    public static List<String> playGame(List<String> carNames, int numberOfMoves) {
        LinkedHashMap<String, Integer> carDistanceResults = new LinkedHashMap<>();
        List<String> winner = new ArrayList<>();

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


    //공백 처리 "woni, jun,pobi "
    //이름이 같을 경우 "woni,woni"
    //한 개만 입력 될 때 처리 "woni"
    //이름에 숫자만 있을 경우 처리 "1234"
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
