package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class Application {

    final LinkedHashMap<String, Integer> carPositions = new LinkedHashMap<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application race = new Application();

        race.readySetGo();
    }

    void printRequestingCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    String getCarNamesInput() {
        String userInput = Console.readLine();
        validateNotEmpty(userInput);
        return userInput;
    }

    void validateNotEmpty(String userInput) {
        if (userInput.isEmpty() || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    String[] splitNamesByComma(String userInput) {
        return userInput.split(",", -1);
    }

    void validateMinimumTwoCars(String[] cars) {
        if (cars.length < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    void validateUniqueCarName(String[] carNames) {
        if (carNames.length != carPositions.size()) {
            throw new IllegalArgumentException("자동차 이름에는 중복이 없어야 합니다.");
        }
    }

    void validateNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            validateNotEmpty(carName);
            validateNameLength(carName);
        }
        validateMinimumTwoCars(carNames);
    }

    void printRequestingRaceRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    int getRaceRoundInput() {
        String str = Console.readLine();
        validateNotEmpty(str);
        return Integer.parseInt(str);
    }

    void initializeCarPositions(String[] cars) {
        for (String carName : cars) {
            carPositions.put(carName, 0);
        }
    }

    void moveCarForward(String car) {
        carPositions.put(car, carPositions.get(car) + 1);
    }

    void printRoundResult(String car) {
        int position = carPositions.get(car);
        System.out.println(car + " : " + "-".repeat(position));
    }

    void executeRaceRound() {
        for (String car : carPositions.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                moveCarForward(car);
            }
            printRoundResult(car);
        }

        System.out.println();
    }

    List<String> getWinnerList() {
        List<String> winner = new ArrayList<>();
        int firstPlacePosition = 0;

        for (String car : carPositions.keySet()) {
            if (carPositions.get(car) > firstPlacePosition) {
                winner.clear();
                winner.add(car);
                firstPlacePosition = carPositions.get(car);
            } else if (carPositions.get(car) == firstPlacePosition) {
                winner.add(car);
            }
        }

        return winner;
    }

    void printWinner(List<String> winnerList) {
        String result = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + result);
    }

    void readySetGo() {
        printRequestingCarNamesInput();
        String userCarNamesInput = getCarNamesInput();
        String[] carNames = splitNamesByComma(userCarNamesInput);

        validateCarNames(carNames);

        initializeCarPositions(carNames);

        validateUniqueCarName(carNames);

        printRequestingRaceRound();
        int userRaceRoundInput = getRaceRoundInput();

        System.out.println("\n실행 결과");

        for (int n = 0; n < userRaceRoundInput; n++) {
            executeRaceRound();
        }

        var result = getWinnerList();
        printWinner(result);
    }
}
