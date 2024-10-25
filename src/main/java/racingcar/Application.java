package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;


public class Application {

    private final LinkedHashMap<String, Integer> carPositions = new LinkedHashMap<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private void printRequestingCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private String getCarNamesInput() {
        return Console.readLine();
    }

    private void validateNotEmpty(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.") ;
        }
    }

    private String[] splitNamesByComma(String userInput) {
        return userInput.split(",");
    }

    private void validateMinimumTwoCars(String[] cars) {
        if (cars.length < 2) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void validateNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    private void printRequestingRaceRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    private int getRaceRoundInput() {
        String str = Console.readLine();
        validateNotEmpty(str);
        return Integer.parseInt(str);
    }

    private LinkedHashMap initializeCarPositions(String[] cars) {
        for (String carName : cars) {
            carPositions.put(carName, 0);
        }
        return carPositions;
    }

    private void moveCarForward(String car) {
        carPositions.put(car, carPositions.get(car) + 1);
    }
}
