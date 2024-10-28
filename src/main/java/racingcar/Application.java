package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Console.readLine();
        checkInputNull(inputCars);

        String[] carList = inputCars.split(",");

        List<Car> cars = new ArrayList<>();
        Set<String> carNames = new HashSet<>();

        makeCarsList(carList, cars, carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttemptCount = Console.readLine();
        int attemptCount = checkAttemptCount(inputAttemptCount);

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            moveOrStop(cars);
        }

        printWinners(cars);

    }

    public static void moveOrStop(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                car.moveCount++;
            }
            System.out.println(car.name + " : " + "-".repeat(car.moveCount));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        cars.sort((o1, o2) -> o2.moveCount - o1.moveCount);

        System.out.print("최종 우승자 : ");

        System.out.print(cars.getFirst().name);

        for (int i = 1; i < cars.size(); i++) {
            if (cars.getFirst().moveCount != cars.get(i).moveCount) {
                break;
            }
            System.out.print(", " + cars.get(i).name);
        }
    }

    public static void makeCarsList(String[] carList, List<Car> cars, Set<String> carNames) {
        for (String s : carList) {
            checkInputNull(s);
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
            s = s.trim();
            if (carNames.contains(s)) {
                throw new IllegalArgumentException();
            } else {
                carNames.add(s);
            }
            cars.add(new Car(s, 0));
        }
    }

    public static void checkInputNull (String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkAttemptCount(String inputAttemptCount) {

        checkInputNull(inputAttemptCount);

        int attemptCount;

        try {
            attemptCount = Integer.parseInt(inputAttemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (attemptCount < 0) {
            throw new IllegalArgumentException();
        }

        return attemptCount;

    }

}

