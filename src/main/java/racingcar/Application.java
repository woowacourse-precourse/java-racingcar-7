package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        RaceInput input = getUserInput();

        String carNames = input.getCarNames();
        int totalAttempts = input.getTotalAttempts();

        String[] carNamesList = splitCarNames(carNames);

        validateCarNamesList(carNamesList);

        List<Car> cars = createCars(carNamesList);

        runRace(cars, totalAttempts);

        RaceOutput.displayRaceResults(cars, totalAttempts);
        RaceOutput.displayWinners(cars);
    }

    public static RaceInput getUserInput() {
        String carNames = getCarNamesInput();
        int totalAttempts = getAttemptsInput();
        return new RaceInput(carNames, totalAttempts);
    }

    private static String getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        validateInputCarNames(carNames);

        return carNames;
    }

    private static int getAttemptsInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempts = Console.readLine();

        return validateInputAttempts(inputAttempts);
    }

    private static void validateInputCarNames(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private static int validateInputAttempts(String inputAttempts) {
        if (inputAttempts == null || inputAttempts.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 비어있을 수 없습니다.");
        }

        int totalAttempts = Integer.parseInt(inputAttempts.trim());

        if (totalAttempts < 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 작을 수 없습니다.");
        }

        return totalAttempts;
    }

    public static String[] splitCarNames(String carNames) {
        String[] carNamesList = carNames.split(",");

        for (int i = 0; i < carNamesList.length; i++) {
            carNamesList[i] = carNamesList[i].trim();
        }

        return carNamesList;
    }

    public static void validateCarNamesList(String[] carNamesList) {
        final int MAX_LENGTH = 5;

        for (String carName : carNamesList) {
            if (carName == null || carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 유효하지 않습니다.");
            }
            if (carName.length() > MAX_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
            }
        }
    }

    public static List<Car> createCars(String[] carNamesList) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNamesList) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public static void runRace(List<Car> cars, int totalAttempts) {
        for (int i = 0; i < totalAttempts; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }
}

