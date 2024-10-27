package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = getInput();
        List<String> carNames = getCarNames(input);
        List<Car> cars = createCars(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        input = getInput();
        Integer movementCount = getMovementCount(input);

        System.out.println("\n실행 결과");

        for (int i = 0; i < movementCount; i++) {
            for (Car car : cars) {
                Integer randomNumber = getRandomNumber();
                Boolean isValidNumber = isValidNumber(randomNumber);

                if (isValidNumber) {
                    car.addDistance();
                }
            }

            for (Car car : cars) {
                System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
            }
            System.out.println();
        }

        String winners = getWinners(cars);
        System.out.println("최종 우승자 : " + winners);
    }

    public static String getInput() {
        return Console.readLine();
    }

    public static List<String> getCarNames(String input) {
        String[] inputArray = input.split(",");

        for (String car : inputArray) {
            if (car.length() > 5 || StringUtils.isBlank(car))
                throw new IllegalArgumentException();
        }

        List<String> cars = Arrays.asList(input.split(","));

        return cars;
    }

    public static Integer getMovementCount(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }

        Integer movemmetCount = Integer.parseInt(input);

        if (movemmetCount <= 0) {
            throw new IllegalArgumentException();
        }

        return movemmetCount;
    }

    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static Boolean isValidNumber(Integer number) {
        return number >= 4;
    }

    public static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    public static String getWinners(List<Car> cars) {
        String winners = "";
        List<String> winnerNames = new ArrayList<>();
        List<Integer> carDistances = new ArrayList<>();

        for (Car car : cars) {
            carDistances.add(car.getDistance());
        }

        Integer maxDistance = Collections.max(carDistances);
        for (Car car : cars) {
            if (car.getDistance().equals(maxDistance)) {
                winnerNames.add(car.getName());
            }
        }

        winners = String.join(",", winnerNames);

        return winners;
    }
}
