package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        List<String> carNames = List.of(carNamesInput.split(","));
        validateCarNames(carNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String triesInput = Console.readLine();
        int numTries = validateAndParseTries(triesInput);

        GameContext gameContext = new GameContext(cars, numTries);
        gameContext.playGame();
    }

    static void validateCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (uniqueCarNames.contains(carName)) {
                throw new IllegalArgumentException();
            } else {
                uniqueCarNames.add(carName);
            }
        }
    }

    static int validateAndParseTries(String triesInput) {
        if (triesInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
        try {
            int numTries = Integer.parseInt(triesInput);
            if (numTries < 1) {
                throw new IllegalArgumentException();
            }
            return numTries;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
